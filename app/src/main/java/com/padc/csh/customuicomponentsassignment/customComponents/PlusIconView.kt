package com.padc.csh.customuicomponentsassignment.customComponents

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class PlusIconView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var size = 0
    private var bgColor = Color.parseColor("#FFFFFF")
    private var borderWidth =6f


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBackground(canvas)
        drawPlus(canvas)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }
    private fun drawBackground(canvas: Canvas?) {

        // 1 set background color to faceColor and fill that color.
        paint.color = bgColor
        paint.style = Paint.Style.FILL

        // 2 calculate the radius of the circle  (320/2) => 160
        val radius = size / 2f

        /**
         * 3
         * @param cx is x-coordinate of circle => 160
         * @param cy is y-coordinate of circle => 160
         *
         * start draw the circle from the center position (x,y) with radius 160 and paint
         */
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)

        // 4 set background stroke color to border color and make it stroke.
        paint.color = bgColor
        paint.style = Paint.Style.STROKE
       // paint.setShadowLayer(50f,width.toFloat() / 2f,height.toFloat()/3f ,Color.parseColor("#33808080"))
        paint.strokeWidth = 4f

        // 5
        canvas?.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)

    }

    private fun drawPlus(canvas: Canvas?) {

        // 1 set background color to eyesColor and fill that color
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL

        /* 2  for left eye
           the first four parameter is left,top,right,bottom to define four point
           eg. (left,top) , (left,bottom) , (right,top) , (right,bottom)
           percentages of the size: (32%, 23%, 43%, 50%)
         */
        val firstRect = RectF(size * 0.30f, size * 0.50f, size * 0.75f, size * 0.55f)

        canvas?.drawRect(firstRect, paint)

        /* 3 for right eye
           percentages of the size: (57%, 23%, 68%, 50%)
         */
        val secondRect = RectF(size * 0.50f, size * 0.35f, size * 0.55f, size * 0.75f)

        // 4
        canvas?.drawRect(secondRect, paint)

    }


}