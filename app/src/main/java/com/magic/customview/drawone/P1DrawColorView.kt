package com.magic.customview.drawone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/**
 * author : maji
 * date   : 12/01/2019
 * mail   : maji@bilibili.com
 */
class P1DrawColorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.YELLOW)
    }

}