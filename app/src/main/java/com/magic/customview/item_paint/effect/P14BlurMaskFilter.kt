package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R


class P14BlurMaskFilter @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()
    private val mBitmap: Bitmap
    private val mRect: Rect
    private val mRectF: RectF

    private val mNormalMaskFilter: BlurMaskFilter
    private val mSolidMaskFilter: BlurMaskFilter
    private val mInnerMaskFilter: BlurMaskFilter
    private val mOuterMaskFilter: BlurMaskFilter

    private val mDelta = 100F

    init {

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 1F
        mPaint.color = Color.BLACK

        //内外都模糊绘制
        mNormalMaskFilter = BlurMaskFilter(100F, BlurMaskFilter.Blur.NORMAL)

        //内部正常绘制，外部模糊
        mSolidMaskFilter = BlurMaskFilter(100F, BlurMaskFilter.Blur.SOLID)

        //内部模糊，外部不绘制
        mInnerMaskFilter = BlurMaskFilter(100F, BlurMaskFilter.Blur.INNER)

        //内部不绘制，外部模糊
        mOuterMaskFilter = BlurMaskFilter(100F, BlurMaskFilter.Blur.OUTER)

        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        mRect = Rect(0, 0, 300, 300)
        mRectF = RectF(mRect)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 在绘制层 上方添加效果
         */
        //关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, mPaint)

        canvas?.save()

        //left top
        canvas?.translate(200F, 200F)
        mPaint.maskFilter = mNormalMaskFilter
        canvas?.drawBitmap(mBitmap, null, mRect, mPaint)

        //right top
        canvas?.translate(mRectF.width() + mDelta, 0F)
        mPaint.maskFilter = mSolidMaskFilter
        canvas?.drawBitmap(mBitmap, null, mRect, mPaint)

        //right bottom
        canvas?.translate(0F, mRectF.height() + mDelta)
        mPaint.maskFilter = mInnerMaskFilter
        canvas?.drawBitmap(mBitmap, null, mRect, mPaint)

        //left bottom
        canvas?.translate( -(mRectF.width() + mDelta), 0F)
        mPaint.maskFilter = mOuterMaskFilter
        canvas?.drawBitmap(mBitmap, null, mRect, mPaint)

        canvas?.restore()

    }

}