package com.magic.customview.item_canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P5CanvasSkew @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mBitmapRectF: RectF = RectF(0F, 0F, 300F, 300F)

    @Suppress("JoinDeclarationAndAssignment")
    private var mBitmap: Bitmap

    init {
        //TODO do it in the back ground thread
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * canvas.rotate() will rotate the canvas axis
         */

        /**             |
         *              |
         *              |
         *              |
         * ---------  origin  --------  x-axis
         *              |
         *              |
         *              |   draw content here
         *              |
         *              |
         *              |
         *                y-axis
         */
        canvas?.save()

        canvas?.translate(mBitmapRectF.width(), mBitmapRectF.height())

        // pivot point default is origin of coordinates
        // 默认 skew 轴心是 坐标系原点
//        canvas?.skew(1F, 1F)

        canvas?.skew(0.8F, 0F)
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        canvas?.restore()
    }

}