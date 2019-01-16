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
class P4DrawPointView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPointers: Array<PointF> = arrayOf(
        PointF(100F, 100F),
        PointF(300F, 100F),
        PointF(100F, 300F)
    )

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true

        mPaint.strokeCap = Paint.Cap.BUTT
        mPaint.strokeWidth = 20F
        canvas?.drawPoint(mPointers[0].x, mPointers[0].y, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(mPointers[1].x, mPointers[1].y, mPaint)

        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawPoint(mPointers[2].x, mPointers[2].y, mPaint)
    }
}