package com.magic.customview.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P5ComposeShaderView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private lateinit var mComposeShader: Shader

    private var mShader: BitmapShader

    private var mShader2: BitmapShader

    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    private var mBitmap2: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    init {
        mShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mShader2 = BitmapShader(mBitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 上面这段代码中我使用了两个 BitmapShader 来作为 ComposeShader() 的参数
         * 而  ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，所以这里也需要关闭硬件加速才能看到效果。
         */
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        //mShader原图像 mShader2目标图像
        mComposeShader = ComposeShader(mShader, mShader2, PorterDuff.Mode.DST_IN)

        mPaint.shader = mComposeShader
        canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
    }
}