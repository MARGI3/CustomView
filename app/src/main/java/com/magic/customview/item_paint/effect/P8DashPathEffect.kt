package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P8DashPathEffect @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()

    private val mDashPath = Path()
    private val mDashPathPaint = Paint()

    private val mDashPathEffect = DashPathEffect(floatArrayOf(20F, 10F), 0F)
    private val mDashPathEffect2 = DashPathEffect(floatArrayOf(20F, 10F), 5F)
    private val mDashPathEffect3 = DashPathEffect(floatArrayOf(20F, 10F), 10F)
    private val mDashPathEffect4 = DashPathEffect(floatArrayOf(20F, 10F), 15F)
    private val mDashPathEffect5 = DashPathEffect(floatArrayOf(20F, 10F), 20F)

    init {
        mDashPathPaint.strokeWidth = 4F
        mDashPathPaint.isAntiAlias = true
        mDashPathPaint.style = Paint.Style.STROKE

        mDashPath.rMoveTo(100F, 0F)
        mDashPath.rLineTo(800F, 0F)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.color = Color.RED
        canvas?.drawLine(100F,50F, 100F, 600F, mPaint)

        /**
         * 使用虚线来绘制线条
         *
         * float[]
         * array 中 偶数value 绘制实线  奇数value 绘制空白
         *
         * phase:
         *      phase参数指定了绘制的虚线相对于起始地址（Path起点）的取余偏移（对路径总长度）
         *
         *      phase = 0 则起点一开始，则绘制图形
         *
         *      phase = n 当 phase = n 相当于 绘制 完 phase = 0 的图形，然后将图形向左偏移 n个单位，并且该 n个单位不会被绘制出来
         *               （模拟效果，实际过程并不是 绘制完 然后移动）
         *
         * 动态的改变 phase 的值，可以达到 虚线移动的 效果
         */

        canvas?.save()

        canvas?.translate(0F, 100F)
        mDashPathPaint.pathEffect = mDashPathEffect
        canvas?.drawPath(mDashPath, mDashPathPaint)

        mDashPathPaint.pathEffect = mDashPathEffect2
        canvas?.translate(0F, 100F)
        canvas?.drawPath(mDashPath, mDashPathPaint)

        mDashPathPaint.pathEffect = mDashPathEffect3
        canvas?.translate(0F, 100F)
        canvas?.drawPath(mDashPath, mDashPathPaint)

        mDashPathPaint.pathEffect = mDashPathEffect4
        canvas?.translate(0F, 100F)
        canvas?.drawPath(mDashPath, mDashPathPaint)

        mDashPathPaint.pathEffect = mDashPathEffect5
        canvas?.translate(0F, 100F)
        canvas?.drawPath(mDashPath, mDashPathPaint)

        canvas?.restore()
    }

}