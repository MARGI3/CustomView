package com.magic.customview.drawone

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P8DrawArcView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mRectF = RectF(100F, 100F, 500F, 300F)
    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆

        //startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）

        //sweepAngle 是弧形划过的角度

        //useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形

        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL

        //startAngle -120F == 240F
        canvas?.drawArc(mRectF, -120F, 80F, true, mPaint)

        mPaint.color = Color.BLUE
        canvas?.drawArc(mRectF, 20F, 140F, false, mPaint)


        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.RED
        //stroke style  userCenter == true 会自动绘制 "半径"
        canvas?.drawArc(mRectF, 180F, 40F, true, mPaint)

        mPaint.color = Color.GREEN
        canvas?.drawArc(mRectF, 20F, -60F, false, mPaint)

    }
}