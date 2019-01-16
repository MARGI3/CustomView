package com.magic.customview.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class P3SweepGradientView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mColorFrom: Int = Color.parseColor("#E91E63")
    private val mColorTo: Int = Color.parseColor("#2196F3")

    private lateinit var mGradient: SweepGradient

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = (left + right) / 2
        val centerY = (top + bottom) / 2

        /**
         * centerX centerY：辐射中心的坐标
         * color0：辐射起始颜色
         * color1：辐射结束颜色
         */
        mGradient = SweepGradient(
            centerX.toFloat(),
            centerY.toFloat(),
            mColorFrom,
            mColorTo)

        mPaint.shader = mGradient

        canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
    }

}