package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class P6StrokeMiter @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()
    private val mPath = Path()

    init {
        mPaint.strokeWidth = 40F
        mPaint.style = Paint.Style.STROKE

        mPath.rLineTo(200F, 0F)
        mPath.rLineTo(-160F, 120F)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()

        canvas?.translate(100F, 100F)
        mPaint.strokeMiter = 1F
        canvas?.drawPath(mPath, mPaint)

        canvas?.translate(300F, 0F)
        mPaint.strokeMiter = 3F
        canvas?.drawPath(mPath, mPaint)

        canvas?.translate(300F, 0F)
        mPaint.strokeMiter = 5F
        canvas?.drawPath(mPath, mPaint)

        canvas?.restore()
    }

}