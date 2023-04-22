package com.padc.csh.customuicomponentsassignment.customComponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.padc.csh.customuicomponentsassignment.R

class CustomProgressLine @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var progress = 0
    private val path = Path()
    private var borderWidth = 4f
    private var cornerRadius = 0f


    init {
        paint.isAntiAlias = true
        paint.strokeWidth = borderWidth
        paint.style = Paint.Style.STROKE
        paint.color = resources.getColor(R.color.colorSecondaryText, null)

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressLine)
            if (a.hasValue(R.styleable.CustomProgressLine_progressAmt)) {
                progress = a.getInteger(R.styleable.CustomProgressLine_progressAmt, 0)
           }

            if (a.hasValue(R.styleable.CustomProgressLine_borderWidthProgressLine)) {
                borderWidth = a.getDimension(R.styleable.CustomProgressLine_borderWidthProgressLine, 4f)
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.strokeWidth = borderWidth
        canvas?.drawLine(0f,borderWidth,width.toFloat(),borderWidth,paint)

        var progressF=(progress.toFloat()/100)*width
        paint.color=resources.getColor(R.color.colorAccent, null)
        canvas?.drawLine(0f,borderWidth,progressF,borderWidth,paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }


}