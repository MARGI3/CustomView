package com.magic.customview.drawone

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P4DrawPointView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPointers: Array<Point> = arrayOf(
        Point(100, 100),
        Point(300, 100),
        Point(100, 300)
    )

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true

        mPaint.strokeCap = Paint.Cap.BUTT
        mPaint.strokeWidth = 20F
        canvas?.drawPoint(mPointers[0].x.toFloat(), mPointers[0].y.toFloat(), mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(mPointers[1].x.toFloat(), mPointers[1].y.toFloat(), mPaint)

        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawPoint(mPointers[2].x.toFloat(), mPointers[2].y.toFloat(), mPaint)
    }
}