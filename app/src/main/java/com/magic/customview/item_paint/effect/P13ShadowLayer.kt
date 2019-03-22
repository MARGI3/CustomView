package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P13ShadowLayer @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()
    private val mText = "setShadowLayer Hey Hey Hey"

    init {

        //绘制实心文字
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 60F

        /**
         * radius 是阴影的模糊范围； dx dy 是阴影的偏移量
         * radius 越大 颜色由深到浅 越明显
         * dx  阴影距离实体的 x轴距离
         * dy  阴影距离实体的 y轴距离
         */
        mPaint.setShadowLayer(30F, 4F, 4F, Color.BLUE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 在绘制图层底下 加上阴影效果
         */

        canvas?.save()
        canvas?.translate(100F, 300F)
        canvas?.drawText(mText, 12F, 10F, mPaint)
        canvas?.restore()

        //clear shadow layer
//        mPaint.clearShadowLayer()
    }

}