package com.magic.customview.item_paint.color

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class P2RadialGradientView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mColorCenter: Int = Color.parseColor("#E91E63")
    private val mColorEdge: Int = Color.parseColor("#2196F3")

    @Suppress("unused")
    private val mColorsArray: IntArray = intArrayOf(
        Color.parseColor("#E91E63"),
        Color.parseColor("#A91111"),
        Color.parseColor("#898888"),
        Color.parseColor("#663366"),
        Color.parseColor("#2196F3")
    )

    @Suppress("unused")
    private val mStops: FloatArray = floatArrayOf(0.2F, 0.3F, 0.4F, 0.5F, 0.6F)

    private lateinit var mGradient: RadialGradient

    @Suppress("KDocUnresolvedReference")
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = (left + right) / 2
        val centerY = (top + bottom) / 2

        val radius = Math.min(right - left, bottom - top) / 2

        /**
         * centerX centerY：辐射中心的坐标
         * radius：辐射半径
         * centerColor：辐射中心的颜色
         * edgeColor：辐射边缘的颜色
         * tileMode：辐射范围之外的着色模式
         */
        mGradient = RadialGradient(
            centerX.toFloat(),
            centerY.toFloat(),
            radius.toFloat(),
            mColorCenter,
            mColorEdge,
            Shader.TileMode.CLAMP)


        /**
         * centerX centerY：辐射中心的坐标
         * radius：辐射半径
         * colors：辐射颜色渐变值数组
         * stops：辐射颜色渐变值 对应的范围 以半径的形式向外扩张
         * tileMode：辐射范围之外的着色模式
         */

        /**
         * stops 和 colors 一一对应
         * stops (0.0F -> 1.0F)
         * 按照当前例子的 value
         * stops[0] = 0.2F 表明 color[0]对应颜色 渲染范围值  radius * 0 -> radius * 0.2
         * stops[1] = 0.3F 表明 color[1]对应颜色值 渲染范围  radius * 0.2 -> radius * 0.3
         * stops[2] = 0.4F 表明 color[1]对应颜色值 渲染范围  radius * 0.3 -> radius * 0.4
         * ...
         * 依次类推
         */
//        mGradient = RadialGradient(
//            centerX.toFloat(),
//            centerY.toFloat(),
//            radius.toFloat(),
//            mColorsArray,
//            mStops,
//            Shader.TileMode.CLAMP
//        )

        /**
         * stops 可以为 null，当 stops 为null时 颜色渐变 就按照 colors 的 size 等分均分 渐变
         */
//        mGradient = RadialGradient(
//            centerX.toFloat(),
//            centerY.toFloat(),
//            radius.toFloat(),
//            mColorsArray,
//            null,
//            Shader.TileMode.CLAMP
//        )

        mPaint.shader = mGradient

        canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
    }

}