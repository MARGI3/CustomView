package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View


class P1AntiAliasView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()
    private val mCenter = PointF(400F, 400F)
    private val mRadius = 200F
    private val mRadius2 = 300F
    private val mStrokeWidth = 10F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.strokeWidth = mStrokeWidth
        mPaint.style = Paint.Style.STROKE

        mPaint.isAntiAlias = true
        canvas?.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint)

        mPaint.isAntiAlias = false
        canvas?.drawCircle(mCenter.x, mCenter.y, mRadius2, mPaint)
    }

}