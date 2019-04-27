package com.magic.customview.item_canvas.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R


class P2MatrixTranslate @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private val mBitmapRectF: RectF = RectF(0F, 0F, 80F, 80F)

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

        mMatrix.postTranslate(300F, 300F)

        canvas?.concat(mMatrix)

        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, mPaint)

        canvas?.restore()
    }

}