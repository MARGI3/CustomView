package com.magic.customview.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P9XfermodeView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private var mBitmap1: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private var mBitmap2: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    private lateinit var mXfermode: Xfermode

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        /**
         * Off-screen Buffer
         * 使用离屏缓冲，把要绘制的内容单独绘制在缓冲层
         * 使 PorterDuff操作在单独图层进行，然后在 restore在view上
         */
        val savedLayer = canvas?.saveLayer(RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat()), mPaint, Canvas.ALL_SAVE_FLAG)

        mXfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)

        /**
         * Xfermode 指的是你要绘制的内容和 Canvas 的目标位置的内容应该怎样结合计算出最终的颜色
         *
         * 以绘制的内容作为源图像(SRC), 以 View 中已有的内容作为目标图像 (DST)
         */
        //DST
        canvas?.drawBitmap(mBitmap1, 0F, 0F, mPaint)
        mPaint.xfermode = mXfermode
        //SRC
        canvas?.drawBitmap(mBitmap2, 0F, 0F, mPaint)
        mPaint.xfermode = null

        canvas?.restoreToCount(savedLayer!!)
    }
}