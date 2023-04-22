package com.padc.csh.customuicomponentsassignment.customComponents

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.padc.csh.customuicomponentsassignment.R

class CircleProfileImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs,defStyleAttr) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var cornerRadius = 0f
    private var bordercColor = DEFAULT_BORDER_COLOR
    private val path = Path()
    private var size = 0

    companion object{

        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 6.0f
        private const val DEFAULT_CORNER_RADIUS =0f

    }

    init {

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleProfileImageView)
            if (a.hasValue(R.styleable.CircleProfileImageView_cornerRadius)) {
                cornerRadius= a.getDimension(R.styleable.CircleProfileImageView_cornerRadius,0f)
               bordercColor  = a.getColor(R.styleable.CircleProfileImageView_borderColor,
                    DEFAULT_BORDER_COLOR)

            }
        }
    }

    override fun onDraw(canvas: Canvas?) {

        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())

        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        //path.addRoundRect()
        canvas?.clipPath(path)
        super.onDraw(canvas)
       //canvas?.drawPath(path,paint)
        paint.strokeWidth = DEFAULT_BORDER_WIDTH
        paint.style = Paint.Style.STROKE
        paint.color = bordercColor
        paint.setShadowLayer(100f,width.toFloat() / 2f,height.toFloat() ,Color.parseColor("#808080"))
        //canvas?.clip
        canvas?.drawCircle(size / 2f, size / 2f, cornerRadius - DEFAULT_BORDER_WIDTH / 2f , paint)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 1 get minimum value
        size = measuredWidth.coerceAtMost(measuredHeight)

        // 2 override width and height
        setMeasuredDimension(size, size)
    }



}

