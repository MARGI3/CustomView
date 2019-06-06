package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.LinearLayoutCompat
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
class P4DispatchDrawLayoutView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val pattern = Pattern()

    init {
        mPaint.color = Color.GREEN
        mPaint.strokeWidth = 4F

        setWillNotDraw(false)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        pattern.draw(canvas, width, height)
    }
}