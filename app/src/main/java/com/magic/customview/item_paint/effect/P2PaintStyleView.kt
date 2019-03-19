package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View


class P2PaintStyleView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()
    private val mCenter = PointF(300F, 300F)
    private val mCenter2 = PointF(700F, 300F)
    private val mRadius = 100F
    private val mRadius2 = 100F
    private val mStrokeWidth = 10F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.strokeWidth = mStrokeWidth
        mPaint.isAntiAlias = true

        mPaint.style = Paint.Style.STROKE
        canvas?.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint)

        mPaint.style = Paint.Style.FILL
        canvas?.drawCircle(mCenter2.x, mCenter2.y, mRadius2, mPaint)
    }

}