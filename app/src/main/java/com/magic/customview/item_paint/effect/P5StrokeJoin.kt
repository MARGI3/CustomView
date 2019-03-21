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

    private val mPoint1 = PointF(150F, 100F)
    private val mPoint2 = PointF(200F, 0F)
    private val mPoint3 = PointF(-50F, 100F)
    private val mPath = Path()

    private val mDelta = 100F
    private val mPaint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 这里通过drawPath完成拐角才能看出 Join效果
         * 通过 canvas drawLine 拼接成的拐角没有Join效果
         */
        mPaint.strokeWidth = 30F
        mPaint.style = Paint.Style.STROKE

        //设置起始点
        mPath.moveTo(mPoint1.x, mPoint1.y)

        //default value is MITER no need to set
//        mPaint.strokeJoin = Paint.Join.MITER
        mPath.rLineTo(mPoint2.x, mPoint2.y)
        mPath.rLineTo(mPoint3.x, mPoint3.y)
        canvas?.drawPath(mPath, mPaint)

        //找一个新的绘画起点
        mPath.rMoveTo(-mPoint3.x, -mPoint3.y)
        mPath.rMoveTo(mDelta, 0F)

        mPaint.strokeJoin = Paint.Join.ROUND
        mPath.rLineTo(mPoint2.x , mPoint2.y)
        mPath.rLineTo(mPoint3.x, mPoint3.y)
        canvas?.drawPath(mPath, mPaint)

        //找一个新的绘画起点
        mPath.rMoveTo(-mPoint3.x, -mPoint3.y)
        mPath.rMoveTo(mDelta, 0F)

        mPaint.strokeJoin = Paint.Join.BEVEL
        mPath.rLineTo(mPoint2.x , mPoint2.y)
        mPath.rLineTo(mPoint3.x, mPoint3.y)
        canvas?.drawPath(mPath, mPaint)
    }
}