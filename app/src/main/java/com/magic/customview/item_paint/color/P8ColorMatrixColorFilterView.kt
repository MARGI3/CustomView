package com.magic.customview.item_paint.color

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P8ColorMatrixColorFilterView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), View.OnClickListener, View.OnLongClickListener {

    private val mPaint: Paint = Paint()

    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.sea_original)

    private var mResetFilter = false

    private val mColorMatrix: ColorMatrix = ColorMatrix()

    private val mMatrixArrayList: ArrayList<FloatArray> = ArrayList()

    private var mIndex = 0

    private val mCommonMatrixArray: FloatArray = floatArrayOf(
        1F, 0F, 0F, 0F, 0F,
        0F, 1F, 0F, 0F, 0F,
        0F, 0F, 1F, 0F, 0F,
        0F, 0F, 0F, 1F, 0F
    )

    private val mGreyScaleMatrixArray: FloatArray = floatArrayOf(
        0.33F, 0.59F, 0.11F, 0F, 0F,
        0.33F, 0.59F, 0.11F, 0F, 0F,
        0.33F, 0.59F, 0.11F, 0F, 0F,
        0F, 0F, 0F, 1F, 0F
    )

    private val mInvertMatrixArray: FloatArray = floatArrayOf(
        -1F, 0F, 0F, 0F, 255F,
        0F, -1F, 0F, 0F, 255F,
        0F, 0F, -1F, 0F, 255F,
        0F, 0F, 0F, 1F, 0F
    )

    private val mSEPIAMatrixArray: FloatArray = floatArrayOf(
        0.393F, 0.769F, 0.189F, 0F, 0F,
        0.349F, 0.686F, 0.168F, 0F, 0F,
        0.272F, 0.534F, 0.131F, 0F, 0F,
        0F, 0F, 0F, 1F, 0F
    )

    private val mBrightMatrixArray: FloatArray = floatArrayOf(
        1.438F, -0.122F, -0.016F, 0F, 0F,
        -0.062F, 1.378F, -0.016F, 0F, 0F,
        -0.062F, -0.122F, 1.483F, 0F, 0F,
        0F, 0F, 0F, 1F, 0F
    )


    private val mBlackAndWhiteMatrixArray: FloatArray = floatArrayOf(
        1.5F, 1.5F, 1.5F, 0F, -255F,
        1.5F, 1.5F, 1.5F, 0F, -255F,
        1.5F, 1.5F, 1.5F, 0F, -255F,
        0F, 0F, 0F, 1F, 0F
    )


    init {
        setOnClickListener(this)
        setOnLongClickListener(this)
        mMatrixArrayList.apply {
            add(mCommonMatrixArray)
            add(mGreyScaleMatrixArray)
            add(mInvertMatrixArray)
            add(mSEPIAMatrixArray)
            add(mBrightMatrixArray)
            add(mBlackAndWhiteMatrixArray)
        }
    }

    /**
     *
     * ColorMatrix 是一个 4 * 5 的矩阵
     * [ a, b, c, d, e,
     *   f, g, h, i, j,
     *   k, l, m, n, o,
     *   p, q, r, s, t ]
     *
     *   ColorMatrix 可以把要绘制的 像素 进行对应的转换  [R, G, B, A]
     *
     *   R’ = a * R + b * G + c * B + d * A + e;
     *   G’ = f * R + g * G + h * B + i * A + j;
     *   B’ = k * R + l * G + m * B + n * A + o;
     *   A’ = p * R + q * G + r * B + s * A + t;
     *
     *   更多关于 ColorMatrixColorFilter 的内容
     *
     *   https://github.com/chengdazhi/StyleImageView
     */

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mResetFilter) {
            mPaint.colorFilter = null
        } else {
            mColorMatrix.set(mMatrixArrayList[mIndex])
            mPaint.colorFilter = ColorMatrixColorFilter(mColorMatrix)
        }
        canvas?.drawBitmap(mBitmap, matrix, mPaint)

        mPaint.color = Color.WHITE
        mPaint.textSize = 50F
        canvas?.drawText("Click to change matrix", 50F, 50F, mPaint)
        canvas?.drawText("Long click to reset", 50F, 150F, mPaint)
        canvas?.drawText("More About ColorMatrixColorFilter", 50F, 250F, mPaint)
        canvas?.drawText("Github StyleImageView", 50F, 350F, mPaint)
    }

    override fun onClick(v: View?) {
        updateIndex()
        reset(false)
        invalidate()
    }

    override fun onLongClick(v: View?): Boolean {
        reset(true)
        invalidate()
        return true
    }

    private fun updateIndex() {
        mIndex = (mIndex + 1) % 3
    }

    private fun reset(reset: Boolean) {
        mResetFilter = reset
    }

}