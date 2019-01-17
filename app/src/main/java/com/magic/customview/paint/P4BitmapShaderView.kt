package com.magic.customview.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P4BitmapShaderView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private lateinit var mShader: BitmapShader

    private lateinit var mMatrix: Matrix

    private lateinit var mBitmap: Bitmap

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = width / 2
        val centerY = height / 2

        val viewSize = Math.min(width, height)

        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val bitmapSize = Math.min(mBitmap.width, mBitmap.height)

        //根据图片和view的尺寸选择合适的半径来画圆， 避免图片太小
        val radius = Math.min(viewSize, bitmapSize) / 2

        mShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        mShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR)
//        mShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT)

        //当前的 drawCircle 是在view中心绘制，所以将 BitmapShader通过 Matrix 平移到 中心位置，保证 drawCircle 是取的 Bitmap 中心
        val dx = Math.abs(mBitmap.width / 2 - centerX)
        val dy = Math.abs(mBitmap.height / 2 - centerY)
        mMatrix = Matrix()
        mMatrix.postTranslate(dx.toFloat(), dy.toFloat())
        mShader.setLocalMatrix(mMatrix)

        mPaint.shader = mShader
        canvas?.drawCircle(centerX.toFloat(), centerY.toFloat(), radius.toFloat(), mPaint)

        /**
         * BitmapShader 默认在view左上角，而 canvas draw 是可以在view 的任意区域
         * 所以在某些情况下需要移动BitmapShader的位置来画出合适的图形
         * 这时可以通过 matrix 来完成平移等其他操作
         *
         * |--------------------------------|
         * | *****************              |
         * | *               *              |
         * | *  BitmapShader *              |
         * | *               *              |
         * | *               *              |
         * | *****************              |
         * |                                |
         * |                                |
         * |                                |
         * |                                |
         * |--------------------------------|
         *
         */
    }
}