package com.magic.customview.item_drawbasic

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P6DrawLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPoints = floatArrayOf(175F, 50F, 175F, 300F, 50F, 300F, 300F, 300F)
    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响

        //startX, startY, stopX, stopY 分别是线的起点和终点坐标

        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 10F

        canvas?.drawLine(50F, 50F, 300F, 50F,  mPaint)

        //drawLines() 是 drawLine() 的复数版
        //FloatArray size 必须是4的倍数
        mPaint.color = Color.BLUE
        canvas?.drawLines(mPoints, mPaint)
    }
}