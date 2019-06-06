package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatEditText
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
class P8BeforeDrawView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.textSize = 60F
    }

    override fun draw(canvas: Canvas?) {
        // 在 super.draw() 的上方插入绘制代码，让绘制内容被其他所有内容盖住
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        canvas?.drawColor(Color.parseColor("#66BB6A")) // 涂上绿色
        super.draw(canvas)
    }
}