package com.magic.customview.item_draw_order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.util.Log
import com.magic.customview.BuildConfig
import com.magic.customview.R

/**
 * Draw traversal performs several drawing steps which must be executed
 * in the appropriate order:
 *
 *      1. Draw the background
 *      2. If necessary, save the canvas' layers to prepare for fading
 *      3. Draw view's content
 *      4. Draw children
 *      5. If necessary, draw the fading edges and restore layers
 *      6. Draw decorations (scrollbars for instance)
 *
 *         draw()
 *      1. drawBackground()
 *      2.
 *      3. onDraw()
 *      4. dispatchDraw()
 *      5.
 *      6. drawForeground()
 */
class P3OnDrawLayoutView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val pattern = Pattern()

    init {
        mPaint.color = Color.GREEN
        mPaint.strokeWidth = 4F

        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        pattern.draw(canvas, width, height)
    }
}

class Pattern {

    private val patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var spots: Array<Spot>

    constructor() {
        spots = arrayOf(
            Spot(0.24f, 0.3f, 0.026f),
            Spot(0.69f, 0.25f, 0.067f),
            Spot(0.32f, 0.6f, 0.067f),
            Spot(0.62f, 0.78f, 0.083f)
        )
    }

    constructor(spotArray: Array<Spot>) {
        this.spots = spotArray
    }

    init {
        patternPaint.color = Color.parseColor("#A0E91E63")
    }

    fun draw(canvas: Canvas?, width: Int, height: Int) {
        canvas?.let {
            for (index in 0..(spots.size)) {
                val tempSpot = spots[index % spots.size]
                val cx = width * tempSpot.relativeX
                val cy = height * tempSpot.relativeY
                val radius = tempSpot.relativeSize * height
                canvas.drawCircle(cx, cy, radius, patternPaint)
            }
        }
    }

}

class Spot(
    var relativeX: Float = 0F,
    var relativeY: Float = 0F,
    var relativeSize: Float = 0F
)