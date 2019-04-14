package com.magic.customview.item_drawtext

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : magic
 * date   : 14/04/2019
 * mail   : 562224864cross@gmail.com
 */
class P1DrawTextView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mRectF: RectF = RectF(200F, 200F, 600F, 400F)
    private val mPaint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 1F
        mPaint.color = Color.BLACK

        canvas?.drawRect(mRectF, mPaint)

        /**
         *  text 是文字内容，x 和 y 是文字的坐标。
         *  但需要注意：这个坐标并不是文字的左上角，而是一个与左下角比较接近的位置
         */

        mPaint.strokeWidth = 6F
        mPaint.textSize = 64F
        canvas?.drawText("Hello World", mRectF.left, mRectF.bottom, mPaint)
    }
}