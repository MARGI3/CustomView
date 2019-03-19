package com.magic.customview.item_drawbasic

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author : Magic
 * date   : 12/01/2019
 * mail   : 562224864cross@gmail.com
 */
class P10DrawFillTypeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()
    private val mPath: Path = Path()

    private val mRectF: RectF = RectF(50F, 50F, 100F, 100F)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.isAntiAlias = true
        mPaint.color = Color.BLACK


        /**
         * EVEN_ODD
         * WINDING
         * INVERSE_EVEN_ODD
         * INVERSE_WINDING
         */

        /**
         * EVEN_ODD  交叉填充
         *
         * 即 even-odd rule （奇偶原则）：对于平面中的任意一点，向任意方向射出一条射线。
         * 这条射线和图形相交的次数（相交才算，相切不算哦）如果是奇数，则这个点被认为在图形内部，是要被涂色的区域；
         * 如果是偶数，则这个点被认为在图形外部，是不被涂色的区域。还以左右相交的双圆为例
         */



    }
}