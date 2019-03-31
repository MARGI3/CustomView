package com.magic.customview.item_paint.effect

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class P4StrokeCap @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint()
    private val mPaint2 = Paint()
    private val mStart = PointF(100F, 300F)
    private val mEnd = PointF(600F, 300F)
    private val mDeltaY = 100F

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.style = Paint.Style.STROKE
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 50F

        mPaint2.style = Paint.Style.STROKE
        mPaint2.strokeWidth = 0F

        mPaint.strokeCap = Paint.Cap.BUTT
        canvas?.drawLine(mStart.x, mStart.y, mEnd.x, mEnd.y, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawLine(mStart.x, mStart.y + mDeltaY, mEnd.x, mEnd.y + mDeltaY, mPaint)

        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawLine(mStart.x, mStart.y + 2 * mDeltaY, mEnd.x, mEnd.y + 2 * mDeltaY, mPaint)

        //dash line
        mPaint2.color = Color.RED
        val array = FloatArray(2)
        array[0] = 4F
        array[1] = 4F
        mPaint2.pathEffect = DashPathEffect(array, 0F)
        //path effect 禁止硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, mPaint2)


        canvas?.drawLine(mStart.x, mStart.y - mDeltaY, mStart.x, mStart.y + 3 * mDeltaY, mPaint2)

        canvas?.drawLine(mEnd.x, mEnd.y - mDeltaY, mEnd.x, mEnd.y + 3 * mDeltaY, mPaint2)
    }

}