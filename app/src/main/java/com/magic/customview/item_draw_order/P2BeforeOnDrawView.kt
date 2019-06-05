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