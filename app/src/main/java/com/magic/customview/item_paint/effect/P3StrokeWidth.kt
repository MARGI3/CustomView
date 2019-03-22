package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View


class P3StrokeWidth @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()
    private val mCenter = PointF(300F, 300F)
    private val mCenter2 = PointF(700F, 300F)
    private val mRadius = 100F
    private val mRadius2 = 100F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.style = Paint.Style.STROKE
        mPaint.isAntiAlias = true

        /**
         * 默认情况下，线条宽度为 0，但这个时候它依然能够画出线，线条的宽度为 1 像素
         *
         * 你可以为 Canvas 设置 Matrix 来实现几何变换（如放大、缩小、平移、旋转），在几何变换之后 Canvas 绘制的内容就会发生相应变化，
         *
         * 包括线条也会加粗，例如 2 像素宽度的线条在 Canvas 放大 2 倍后会被以 4 像素宽度来绘制。
         *
         * 而当线条宽度被设置为 0 时，它的宽度就被固定为 1 像素，就算 Canvas 通过几何变换被放大，它也依然会被以 1 像素宽度来绘制。
         *
         * Google 在文档中把线条宽度为 0 时称作「hairline mode（发际线模式）」
         */
        mPaint.strokeWidth = 5F
        canvas?.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint)

        mPaint.strokeWidth = 30F
        canvas?.drawCircle(mCenter2.x, mCenter2.y, mRadius2, mPaint)
    }

}