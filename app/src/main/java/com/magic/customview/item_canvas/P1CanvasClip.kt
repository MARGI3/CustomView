package com.magic.customview.item_canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P1CanvasClip @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mBitmapRectF: RectF = RectF(0F, 0F, 400F, 400F)

    private val mCirclePath: Path = Path()

    private val mTrianglePath: Path = Path()

    @Suppress("JoinDeclarationAndAssignment")
    private var mBitmap: Bitmap

    init {
        //TODO do it in the back ground thread
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

        mCirclePath.addCircle(mBitmapRectF.centerX(),
            mBitmapRectF.centerY(),
            Math.min(mBitmapRectF.width(), mBitmapRectF.height() / 2),
            Path.Direction.CW)

        mTrianglePath.rLineTo(mBitmapRectF.width() / 2, 0F)
        mTrianglePath.lineTo(mBitmapRectF.right, mBitmapRectF.bottom)
        mTrianglePath.lineTo(mBitmapRectF.left, mBitmapRectF.bottom)
        mTrianglePath.lineTo(mBitmapRectF.width() / 2, 0F)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        val delta = 50F

        canvas?.save()
        canvas?.translate(mBitmapRectF.width() + delta, 0F)
        canvas?.clipRect(mBitmapRectF.left + delta, mBitmapRectF.top + delta, mBitmapRectF.right - delta, mBitmapRectF.bottom - delta)
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0F, mBitmapRectF.height() + delta)
        canvas?.clipPath(mCirclePath)
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(mBitmapRectF.height() + delta, mBitmapRectF.height() + delta)
        canvas?.clipPath(mTrianglePath)
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)
        canvas?.restore()
    }

}