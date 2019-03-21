package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P8DiscretePathEffect  @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mDiscretePath = Path()
    private val mDiscretePathPaint = Paint()
    private val mDiscretePathEffect = DiscretePathEffect(10F, 8F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 把线条进行随机的偏离，让轮廓变得乱七八糟
         */
        mDiscretePathPaint.strokeWidth = 6F
        mDiscretePathPaint.isAntiAlias = true
        mDiscretePathPaint.style = Paint.Style.STROKE
        mDiscretePathPaint.pathEffect = mDiscretePathEffect
        mDiscretePath.moveTo(200F, 600F)
        mDiscretePath.rLineTo(200F, -100F)
        mDiscretePath.rLineTo(150F, 200F)
        mDiscretePath.rLineTo(100F, -200F)
        canvas?.drawPath(mDiscretePath, mDiscretePathPaint)
    }

}