package com.magic.customview.item_canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P6CanvasTransformOrder @JvmOverloads constructor(
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

        // save() restore() 之间的 transform 操作看做一个操作集合
        //不同 操作集合之间的效果 还是顺序执行
        //一个操作集合内 顺序是倒叙执行

        /**
         * 整体看 操作集合1 和 操作集合2
         *
         * 代码顺序 和 效果顺序 保持一致是正序
         *
         *
         * 操作集合1 之内
         *
         * 代码顺序: 操作1 -> 操作2 -> 操作3 -> 操作4
         * 效果顺序: 操作4 -> 操作3 -> 操作2 -> 操作1
         *
         * 代码顺序 和 效果顺序是 相反的
         *
         */

        /**
         * 操作集合1
         */
        canvas?.save()

        //操作1
        canvas?.translate(0F, 800F)

        //操作2
        canvas?.rotate(-45F, 0F, 0F)

        //操作3
        canvas?.translate(100F, 0F)

        //操作4
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        canvas?.restore()

        /**
         * 操作集合2
         */
        canvas?.save()

        canvas?.translate(0F, 100F)

        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        canvas?.restore()

    }

}