package com.magic.customview.item_canvas.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R


class P1MatrixPreAndPost @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mBitmapRectF: RectF = RectF(0F, 0F, 150F, 150F)

    private val mMatrix: Matrix = Matrix()

    @Suppress("JoinDeclarationAndAssignment")
    private var mBitmap: Bitmap

    init {
        //TODO do it in the background thread
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()

        /**
         * 当Matrix只有一种变换的时候，使用preXXX postXXX 没有区别
         *
         * 当Matrix有多种变换组合的时候，由于矩阵 乘法不满足交换律 所以顺序不同结果不同
         *
         * preXXX (前乘) 将当前矩阵放在前面，右侧乘以 变换矩阵
         *
         * M' = M * T(dx, dy)
         *
         * postXXX (后乘) 将当前矩阵放在后面，左侧乘以 变换矩阵
         *
         * M' = M * T(dx, dy)
         *
         *
         *
         * 举例说明：
         *
         * 例一
         *   1. postTranslate(300F, 300F)
         *   2. postRotate(90F)
         *   3. postTranslate(100F, 0F)
         *
         *   1.    M * (post)Trans
         *   2.  { M * (post)Trans } * (post)Rotate
         *   3. {{ M * (post)Trans } * (post)Rotate } * (post)Trans
         *
         *   所以效果就是
         *   1. 先向右下角平移
         *   2. 原点为轴心 旋转
         *   3. 再向X轴正方向平移
         *
         * 例二
         *   1. postTranslate(300F, 300F)
         *   2. preRotate(90F)
         *   3. postTranslate(100F, 0)
         *
         *   1.    M * (post)Trans
         *   2.  { M * (pre)Rotate } * (post)Trans
         *   3. {{ M * (pre)Rotate } * (post)Trans } * (post)Trans
         *
         *   所以效果就是
         *   1. 原点为轴心 旋转
         *   2. 先向右下角平移
         *   3. 再向X轴正方向平移
         *
         * 例三
         *   1. postTranslate(300F, 300F)
         *   2. preRotate(90F)
         *   3. preTranslate(100F, 0)
         *
         *   1.    M * (post)Trans
         *   2.  { M * (pre)Rotate } * (post)Trans
         *   3. {{ M * (pre)Trans } * (pre)Rotate } * (post)Trans
         *
         *   所以效果就是
         *   1. 先向X轴正方向平移
         *   2. 原点为轴心 旋转
         *   3. 再向右下角平台
         */

//        mMatrix.postTranslate(300F, 300F)
//        mMatrix.postRotate(90F)
//        mMatrix.postTranslate(100F, 0F)
//
//        mMatrix.postTranslate(300F, 300F)
//        mMatrix.preRotate(90F)
//        mMatrix.postTranslate(100F, 0F)

        mMatrix.postTranslate(300F, 300F)
        mMatrix.preRotate(90F)
        mMatrix.preTranslate(100F, 0F)


        canvas?.concat(mMatrix)

        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        canvas?.restore()
    }

}