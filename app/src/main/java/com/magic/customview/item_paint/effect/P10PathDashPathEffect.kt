package com.magic.customview.item_paint.effect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class P10PathDashPathEffect @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mShapePath = Path()

    private val mDashPath = Path()
    private val mDashPathPaint = Paint()
    private val mDashPathEffect: PathDashPathEffect
    private val mDashPathEffect2: PathDashPathEffect
    private val mDashPathEffect3: PathDashPathEffect

    init {
        mDashPath.addCircle(300F, 300F, 200F, Path.Direction.CW)

        mDashPathPaint.style = Paint.Style.STROKE

        mShapePath.rLineTo(30F, 0F)
        mShapePath.rLineTo(0F, 26F)
        mShapePath.close()

        mDashPathEffect = PathDashPathEffect(mShapePath, 50F, 0F, PathDashPathEffect.Style.MORPH)
        mDashPathEffect2 = PathDashPathEffect(mShapePath, 50F, 0F, PathDashPathEffect.Style.TRANSLATE)
        mDashPathEffect3 = PathDashPathEffect(mShapePath, 50F, 0F, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()

        canvas?.translate(100F, 0F)
        mDashPathPaint.pathEffect = mDashPathEffect
        canvas?.drawPath(mDashPath, mDashPathPaint)

        canvas?.translate(0F, 450F)
        mDashPathPaint.pathEffect = mDashPathEffect2
        canvas?.drawPath(mDashPath, mDashPathPaint)

        canvas?.translate(0F, 450F)
        mDashPathPaint.pathEffect = mDashPathEffect3
        canvas?.drawPath(mDashPath, mDashPathPaint)

        canvas?.restore()
    }

}