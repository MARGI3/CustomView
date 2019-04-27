package com.magic.customview.item_drawtext

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * author : magic
 * date   : 14/04/2019
 * mail   : 562224864cross@gmail.com
 */
class P3StaticLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mTextPaint = TextPaint()

    private val mText1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
    private val mStaticLayout1: StaticLayout

    private val mText2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz"
    private val mStaticLayout2: StaticLayout

    init {

        mTextPaint.textSize = 48F

        mStaticLayout1 = StaticLayout(mText1, mTextPaint, 600, Layout.Alignment.ALIGN_NORMAL,
            1F, 0F, true)

        mStaticLayout2 = StaticLayout(mText2, mTextPaint, 600, Layout.Alignment.ALIGN_NORMAL,
            1F, 0F, true)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()

        canvas?.translate(50F, 100F)
        mStaticLayout1.draw(canvas)

        canvas?.translate(0F, 200F)
        mStaticLayout2.draw(canvas)

        canvas?.restore()
    }
}