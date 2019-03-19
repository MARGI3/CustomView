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
class P7DrawRoundRectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mRectF = RectF(100F, 100F, 500F, 300F)
    private val mRadiusX = 50F
    private val mRadiusY = 50F
    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径

        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 5F

        canvas?.drawRoundRect(mRectF, mRadiusX, mRadiusY, mPaint)
    }
}