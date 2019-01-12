package com.magic.customview.drawone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P2DrawCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mCenters: Array<Point> = arrayOf(
        Point(100, 100),
        Point(300, 100),
        Point(100, 300),
        Point(300, 300)
    )

    private val mRadius = 50F

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true

        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL
        canvas?.drawCircle(
            mCenters[0].x.toFloat(),
            mCenters[0].y.toFloat(),
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 4F
        canvas?.drawCircle(
            mCenters[1].x.toFloat(),
            mCenters[1].y.toFloat(),
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLUE
        canvas?.drawCircle(
            mCenters[2].x.toFloat(),
            mCenters[2].y.toFloat(),
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 20F
        canvas?.drawCircle(
            mCenters[3].x.toFloat(),
            mCenters[3].y.toFloat(),
            mRadius,
            mPaint
        )
    }
}