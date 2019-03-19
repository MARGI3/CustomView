package com.magic.customview.item_paint.color

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class P1LinearGradientView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    //左上角 到 右下角颜色渐变
    private val mPointF1: PointF = PointF(100F, 100F)
    private val mPointF2: PointF = PointF(500F, 500F)

    //右上角 到 左下角颜色渐变
    private val mPointF3: PointF = PointF(500F, 100F)
    private val mPointF4: PointF = PointF(100F, 500F)

    private val mColorFrom: Int = Color.parseColor("#E91E63")
    private val mColorTo: Int = Color.parseColor("#2196F3")

    private val mGradient1: LinearGradient = LinearGradient(
        mPointF1.x, mPointF1.y, mPointF2.x, mPointF2.y,
        mColorFrom,
        mColorTo,
        Shader.TileMode.CLAMP)

    init {
        mPaint.shader = mGradient1

        /**
         * A(x0, y0) B(x1, y1)
         * A B 两点的方向决定了 渐变的方向
         * A B 两点的距离决定了，渐变的区域，超过区域不会进行渐变（采用起始颜色 或者 最终颜色）
         */

        /**
         * Shader.TileMode
         * 决定了辐射范围之外的着色模式
         */

        //改变线性渐变的方向
//       mPaint.shader = LinearGradient(mPointF3.x, mPointF3.y, mPointF4.x, mPointF4.y, mColorFrom, mColorTo, Shader.TileMode.CLAMP)

        //改变线性渐变的模式
//        mPaint.shader = LinearGradient(mPointF1.x, mPointF1.y, mPointF2.x, mPointF2.y, mColorFrom, mColorTo, Shader.TileMode.MIRROR)
//        mPaint.shader = LinearGradient(mPointF1.x, mPointF1.y, mPointF2.x, mPointF2.y, mColorFrom, mColorTo, Shader.TileMode.REPEAT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
    }

}