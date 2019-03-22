package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P5StrokeJoin @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr)  {

    private val mPoint1 = PointF(0F, 100F)
    private val mPoint2 = PointF(200F, 0F)
    private val mPoint3 = PointF(-50F, 100F)
    private val mPath = Path()

    private val mPaint = Paint()

    init {

        mPaint.strokeWidth = 30F
        mPaint.style = Paint.Style.STROKE

        mPath.rMoveTo(mPoint1.x, mPoint1.y)
        mPath.rLineTo(mPoint2.x, mPoint2.y)
        mPath.rLineTo(mPoint3.x, mPoint3.y)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 这里通过drawPath完成拐角才能看出 Join效果
         * 通过 canvas drawLine 拼接成的拐角没有Join效果
         */

        canvas?.save()

        mPaint.strokeJoin = Paint.Join.MITER
        canvas?.translate(100F, 0F)
        canvas?.drawPath(mPath, mPaint)

        mPaint.strokeJoin = Paint.Join.ROUND
        canvas?.translate(300F, 0F)
        canvas?.drawPath(mPath, mPaint)

        mPaint.strokeJoin = Paint.Join.BEVEL
        canvas?.translate(300F, 0F)
        canvas?.drawPath(mPath, mPaint)

        canvas?.restore()
    }
}