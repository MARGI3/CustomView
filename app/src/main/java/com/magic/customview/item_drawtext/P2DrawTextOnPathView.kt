package com.magic.customview.item_drawtext

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * author : magic
 * date   : 14/04/2019
 * mail   : 562224864cross@gmail.com
 */
class P2DrawTextOnPathView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mCornerPath = Path()
    private val mPaint = Paint()
    private val mCornerPathEffect = CornerPathEffect(16F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 把所有拐角变成圆角
         */
        mPaint.strokeWidth = 6F
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.pathEffect = mCornerPathEffect
        mCornerPath.moveTo(300F, 300F)
        mCornerPath.rLineTo(200F, -100F)
        mCornerPath.rLineTo(150F, 200F)
        mCornerPath.rLineTo(100F, -200F)
        mCornerPath.rLineTo(100F, 200F)
        canvas?.drawPath(mCornerPath, mPaint)

        //hOffset 在path上左右方向位移
        //vOffset 在path轨迹上下方法位移
        mPaint.textSize = 48F
        canvas?.drawTextOnPath("Hello World, Hello World, Hello World", mCornerPath, 5F, -5F, mPaint)
    }
}