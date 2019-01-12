package com.magic.customview.drawone

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P9DrawPathView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()
    private val mPath: Path = Path()

    private val mPaint2: Paint = Paint()
    private val mPath2: Path = Path()

    private val mArcRectF: RectF = RectF(600F, 50F, 800F, 150F)
    private val mArcRectF2: RectF = RectF(800F, 50F, 1000F, 150F)

    private val mLeftHeartRectF: RectF = RectF(500F, 200F, 700F, 400F)
    private val mRightHeartRectF: RectF = RectF(700F, 200F, 900F, 400F)
    private val mHeartPointF: PointF = PointF(700F, 550F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true
        mPaint.color = Color.BLACK
        /**
         * 第一组 addXxx() ——添加子图形
         */
        //addCircle
        //x, y, radius 这三个参数是圆的基本信息
        //
        // 最后一个参数 dir 是画圆的路径的方向
        //路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise)
        // 对于普通情况，这个参数填 CW 还是填 CCW 没有影响。
        // 它只是在需要填充图形 (Paint.Style 为 FILL 或  FILL_AND_STROKE) 并且图形出现自相交时，用于判断填充范围的

        //addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆

        //addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形

        //addRoundRect(RectF rect, float rx, float ry, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) / addRoundRect(RectF rect, float[] radii, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形

        //addPath(Path path) 添加另一个 Path

        mPaint.style = Paint.Style.FILL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addOval(50F, 50F, 150F, 100F, Path.Direction.CW)
        }

        /**
         * 第二组  xxxTo() --画线 （直线或曲线）
         *
         * 这一组和第一组 addXxx() 方法的区别在于，第一组是添加的完整封闭图形（除了 addPath() ）
         * 而这一组添加的只是一条线
         */

        // lineTo(float x, float y) / rLineTo(float x, float y) 画直线

        // 从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标。
        // 这两个方法的区别是，lineTo(x, y) 的参数是绝对坐标
        // 而 rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是  relatively 「相对地」)

        /**
         * moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
         *      绝对移动       /       相对移动
         */
        //moveTo(x, y) 虽然不添加图形，但它会设置图形的起点，所以它是非常重要的一个辅助方法
        mPath.rMoveTo(200F, 0F)//根据当前位置相对移动

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 6F
        mPath.lineTo(400F, 100F) // 由当前位置 上一次绘制结束点 向 (100, 100) 画一条直线
        mPath.rLineTo(100F, 0F) // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        //所谓当前位置，即最后一次调用画 Path 的方法的终点位置。初始值为原点 (0, 0)。

        //quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
        //这条二次贝塞尔曲线的起点就是当前位置，而参数中的 x1, y1 和 x2, y2 则分别是控制点和终点的坐标。
        // 和 rLineTo(x, y) 同理，rQuadTo(dx1, dy1, dx2, dy2) 的参数也是相对坐标

        //cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) / rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
        // 画三次贝塞尔曲线

        //arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
        //arcTo() 和 addArc()。它们也是用来画线的，但并不使用当前位置作为弧线的起点

        //这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo
        //少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形

        //而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹

        mPath.arcTo(mArcRectF, -160F, 160F, true)

        //直接连线连到弧形起点（有痕迹）
        mPath.arcTo(mArcRectF2, -90F, 160F, false)

        //addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle) / addArc(RectF oval, float startAngle, float sweepAngle)
        //addArc() --equals-- arcTo() + forceMoveTo = true

        mPath.moveTo(50F, 200F)
        //图形未封闭
        mPath.rLineTo(100F, 100F)
        mPath.rLineTo(-80F, 50F)

        mPath.moveTo(200F, 200F)
        mPath.rLineTo(100F, 100F)
        mPath.rLineTo(-80F, 50F)
        // 使用 close() 封闭子图形
        mPath.close()

        canvas?.drawPath(mPath, mPaint)

        //不是所有的子图形都需要使用 close() 来封闭。当需要填充图形时（即 Paint.Style 为  FILL 或 FILL_AND_STROKE），Path 会自动封闭子图形
        mPaint2.style = Paint.Style.FILL
        mPath2.moveTo(350F, 200F)
        mPath2.rLineTo(100F, 100F)
        mPath2.rLineTo(-80F, 50F)

        /**
         * 画心形
         */
        mPath2.arcTo(mLeftHeartRectF, 135F, 225F, true)
        mPath2.lineTo(mHeartPointF.x, mHeartPointF.y)
        mPath2.arcTo(mRightHeartRectF, 180F, 225F, true)
        mPath2.lineTo(mHeartPointF.x, mHeartPointF.y)

        canvas?.drawPath(mPath2, mPaint2)
    }
}