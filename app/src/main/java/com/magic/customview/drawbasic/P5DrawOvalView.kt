package com.magic.customview.drawbasic

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P5DrawOvalView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @Suppress("SpellCheckingInspection")
    private val mRects: Array<RectF> = arrayOf(
        RectF(100F, 0F, 800F, 300F),
        RectF(100F, 400F, 800F, 700F)
    )

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //只能绘制横着的或者竖着的椭圆，不能绘制斜的（斜的倒是也可以，但不是直接使用 drawOval()，而是配合几何变换)
        // left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标

        mPaint.isAntiAlias = true

        mPaint.style = Paint.Style.FILL
        canvas?.drawOval(mRects[0], mPaint)

        //canvas.drawOval(50, 50, 350, 200, paint);


        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 4F
        canvas?.drawOval(mRects[1], mPaint)

    }
}