package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class P7CornerPathEffect  @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mCornerPath = Path()
    private val mCornerPathPaint = Paint()
    private val mCornerPathEffect = CornerPathEffect(16F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 把所有拐角变成圆角
         */
        mCornerPathPaint.strokeWidth = 6F
        mCornerPathPaint.isAntiAlias = true
        mCornerPathPaint.style = Paint.Style.STROKE
        mCornerPathPaint.pathEffect = mCornerPathEffect
        mCornerPath.moveTo(300F, 300F)
        mCornerPath.rLineTo(200F, -100F)
        mCornerPath.rLineTo(150F, 200F)
        mCornerPath.rLineTo(100F, -200F)
        mCornerPath.rLineTo(100F, 200F)
        canvas?.drawPath(mCornerPath, mCornerPathPaint)
    }

}