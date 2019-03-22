package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P12ComposePathEffect @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPath = Path()
    private val mPaint = Paint()

    private val mDashPathEffect: DashPathEffect
    private val mDiscretePathEffect: DiscretePathEffect

    private val mComposePathEffect: ComposePathEffect

    init {
        mPath.rLineTo(200F, 200F)
        mPath.rLineTo(200F, -400F)
        mPath.rLineTo(200F, 400F)
        mPath.rLineTo(200F, -400F)

        mPaint.strokeWidth = 4F
        mPaint.style = Paint.Style.STROKE

        mDashPathEffect = DashPathEffect(floatArrayOf(20F, 10F, 10F, 5F), 0F)
        mDiscretePathEffect = DiscretePathEffect(10F, 10F)

        mComposePathEffect = ComposePathEffect(mDashPathEffect, mDiscretePathEffect)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        /**
         * 先对目标 Path 使用一个 PathEffect
         * 然后再对这个改变后的 Path 使用另一个 PathEffect
         */
        canvas?.save()

        canvas?.translate(100F, 400F)
        mPaint.pathEffect = mComposePathEffect
        canvas?.drawPath(mPath, mPaint)

        canvas?.restore()
    }

}