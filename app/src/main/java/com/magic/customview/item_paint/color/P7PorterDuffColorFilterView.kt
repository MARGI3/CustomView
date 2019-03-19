package com.magic.customview.item_paint.color

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.magic.customview.R

class P7PorterDuffColorFilterView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint = Paint()

    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.colorFilter = PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.DST_IN)
        mPaint.textSize = 50F

        canvas?.drawBitmap(mBitmap, matrix, mPaint)
    }
}