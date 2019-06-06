package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Draw traversal performs several drawing steps which must be executed
 * in the appropriate order:
 *
 *      1. Draw the background
 *      2. If necessary, save the canvas' layers to prepare for fading
 *      3. Draw view's content
 *      4. Draw children
 *      5. If necessary, draw the fading edges and restore layers
 *      6. Draw decorations (scrollbars for instance)
 *
 *         draw()
 *      1. drawBackground()
 *      2.
 *      3. onDraw()
 *      4. dispatchDraw()
 *      5.
 *      6. drawForeground()
 */
class P7AfterDrawView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.textSize = 60F
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        mPaint.color = Color.parseColor("#f44336")
        canvas?.drawRect(0F, 40F, 200F, 120F, mPaint)
        mPaint.color = Color.WHITE
        canvas?.drawText("After super.draw()", 20F, 100F, mPaint)
    }
}