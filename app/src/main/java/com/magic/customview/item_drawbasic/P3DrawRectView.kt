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
class P3DrawRectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @Suppress("SpellCheckingInspection")
    private val mRects: Array<Rect> = arrayOf(
        Rect(100, 100, 400, 400),
        Rect(600, 100, 900, 400)
    )

    private val mPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true

        mPaint.style = Paint.Style.FILL
        canvas?.drawRect(mRects[0], mPaint)

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 4F
        canvas?.drawRect(mRects[1], mPaint)
    }
}