package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.magic.customview.BuildConfig
import com.magic.customview.R


class P1AfterOnDrawView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.color = Color.GREEN
        mPaint.textSize = 28F
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (BuildConfig.DEBUG) {
            val contentDrawable: Drawable? = drawable
            contentDrawable?.let {
                val rect = contentDrawable.bounds
                canvas?.save()
                //将画布范围设置为Drawable的范围
                canvas?.concat(imageMatrix)
                canvas?.drawText(
                    resources.getString(R.string.drawable_size, rect.width(), rect.height()),
                    20F,
                    40F,
                    mPaint
                )
                canvas?.restore()
            }
        }
    }
}