package com.magic.customview.drawbasic

import android.content.Context
import android.graphics.*
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

    private val mCenters: Array<PointF> = arrayOf(
        PointF(100F, 100F),
        PointF(300F, 100F),
        PointF(100F, 300F),
        PointF(300F, 300F)
    )

    private val mRadius = 50F

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true

        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL
        canvas?.drawCircle(
            mCenters[0].x,
            mCenters[0].y,
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 4F
        canvas?.drawCircle(
            mCenters[1].x,
            mCenters[1].y,
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLUE
        canvas?.drawCircle(
            mCenters[2].x,
            mCenters[2].y,
            mRadius,
            mPaint
        )

        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 20F
        canvas?.drawCircle(
            mCenters[3].x,
            mCenters[3].y,
            mRadius,
            mPaint
        )
    }
}