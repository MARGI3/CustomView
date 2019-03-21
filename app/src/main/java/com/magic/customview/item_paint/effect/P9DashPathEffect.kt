package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P9DashPathEffect @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()

    private val mDashPath = Path()
    private val mDashPathPaint = Paint()
    private val mDashPathEffect = DashPathEffect(floatArrayOf(20F, 10F), 0F)

    private val mDashPath2 = Path()
    private val mDashPathPaint2 = Paint()
    private val mDashPathEffect2 = DashPathEffect(floatArrayOf(20F, 10F), 5F)

    private val mDashPath3 = Path()
    private val mDashPathPaint3 = Paint()
    private val mDashPathEffect3 = DashPathEffect(floatArrayOf(20F, 10F), 10F)

    private val mDashPath4 = Path()
    private val mDashPathPaint4 = Paint()
    private val mDashPathEffect4 = DashPathEffect(floatArrayOf(20F, 10F), 15F)

    private val mDashPath5 = Path()
    private val mDashPathPaint5 = Paint()
    private val mDashPathEffect5 = DashPathEffect(floatArrayOf(20F, 10F), 20F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.color = Color.RED
        canvas?.drawLine(100F,100F, 100F, 600F, mPaint)

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
        mDashPathPaint.strokeWidth = 4F
        mDashPathPaint.isAntiAlias = true
        mDashPathPaint.style = Paint.Style.STROKE
        mDashPathPaint.pathEffect = mDashPathEffect
        mDashPath.moveTo(100F, 150F)
        mDashPath.lineTo(1000F, 150F)
        canvas?.drawPath(mDashPath, mDashPathPaint)

        mDashPathPaint2.strokeWidth = 4F
        mDashPathPaint2.isAntiAlias = true
        mDashPathPaint2.style = Paint.Style.STROKE
        mDashPathPaint2.pathEffect = mDashPathEffect2
        mDashPath2.moveTo(100F, 250F)
        mDashPath2.lineTo(1000F, 250F)
        canvas?.drawPath(mDashPath2, mDashPathPaint2)

        mDashPathPaint3.strokeWidth = 4F
        mDashPathPaint3.isAntiAlias = true
        mDashPathPaint3.style = Paint.Style.STROKE
        mDashPathPaint3.pathEffect = mDashPathEffect3
        mDashPath3.moveTo(100F, 350F)
        mDashPath3.lineTo(1000F, 350F)
        canvas?.drawPath(mDashPath3, mDashPathPaint3)

        mDashPathPaint4.strokeWidth = 4F
        mDashPathPaint4.isAntiAlias = true
        mDashPathPaint4.style = Paint.Style.STROKE
        mDashPathPaint4.pathEffect = mDashPathEffect4
        mDashPath4.moveTo(100F, 450F)
        mDashPath4.lineTo(1000F, 450F)
        canvas?.drawPath(mDashPath4, mDashPathPaint4)

        mDashPathPaint5.strokeWidth = 4F
        mDashPathPaint5.isAntiAlias = true
        mDashPathPaint5.style = Paint.Style.STROKE
        mDashPathPaint5.pathEffect = mDashPathEffect5
        mDashPath5.moveTo(100F, 550F)
        mDashPath5.lineTo(1000F, 550F)
        canvas?.drawPath(mDashPath5, mDashPathPaint5)
    }

}