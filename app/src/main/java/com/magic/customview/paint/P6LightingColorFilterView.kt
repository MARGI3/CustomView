package com.magic.customview.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P6LightingColorFilterView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), View.OnClickListener, View.OnLongClickListener {

    private val mPaint: Paint = Paint()

    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    private val mMultiplyColors: IntArray = intArrayOf(0x66FFFF, 0xFF66FF, 0xFFFF66)

    private val mAddColors: IntArray = intArrayOf(0x110000, 0x001100, 0x000011)

    private var mIndex = 0

    private var mResetFilter = false

    init {
        setOnClickListener(this)
        setOnLongClickListener(this)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.colorFilter = if (mResetFilter) {
            LightingColorFilter(0xFFFFFF, 0x000000)
        } else {
            LightingColorFilter(mMultiplyColors[mIndex], mAddColors[mIndex])
        }

        canvas?.drawBitmap(mBitmap, matrix, mPaint)

        mPaint.color = Color.WHITE
        mPaint.textSize = 50F
        canvas?.drawText("Click to change color", 50F, 50F, mPaint)
        canvas?.drawText("Long click to reset", 50F, 150F, mPaint)
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