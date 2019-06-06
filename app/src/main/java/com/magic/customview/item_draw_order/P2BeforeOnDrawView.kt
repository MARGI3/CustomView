package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.magic.customview.BuildConfig
import com.magic.customview.R

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
class P2BeforeOnDrawView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mDeltaValue = 6F

    init {
        mPaint.color = Color.GREEN
        mPaint.strokeWidth = 4F
    }

    override fun onDraw(canvas: Canvas?) {
        if (BuildConfig.DEBUG) {
            canvas?.save()
            val centerY = top + height / 2F
            canvas?.drawLine(
                left - mDeltaValue,
                centerY - mDeltaValue,
                right + mDeltaValue,
                centerY - mDeltaValue,
                mPaint
            )
            canvas?.drawLine(
                left - mDeltaValue,
                centerY + mDeltaValue,
                right + mDeltaValue,
                centerY + mDeltaValue,
                mPaint
            )
            canvas?.restore()
        }
        super.onDraw(canvas)
    }
}