package com.padc.csh.customuicomponentsassignment.customComponents

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.padc.csh.customuicomponentsassignment.R

class ProgressCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

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
//        context.withStyledAttributes(defStyleAttr, R.styleable.CircleImageView) {
//            cornerRadius=getDimension(R.styleable.CircleImageView_cornerRadius,
//                DEFAULT_CORNER_RADIUS)
//        }


            val a = context.obtainStyledAttributes(attrs, R.styleable.ProgressCircleView)
            if (a.hasValue(R.styleable.ProgressCircleView_cornerRadiusProgress)) {
                cornerRadius =
                    a.getDimension(R.styleable.ProgressCircleView_cornerRadiusProgress, 0f)
                borderWidth =
                    a.getDimension(R.styleable.ProgressCircleView_borderWidthProgress, borderWidth)
                progress = a.getInteger(R.styleable.ProgressCircleView_progress, 0)

            }

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var progressF = ((progress.toFloat() / 100) * 360)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = width / 2f - 4f
        canvas?.drawCircle(centerX, centerY, radius, paint)

        val rectangle =
            RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius)

        //indicator for progress
        paint.color = resources.getColor(R.color.colorProgress, null)
        canvas?.drawArc(rectangle, -90f, progressF, false, paint)


        // percent text
        val percentText = "${progress}%"
        var textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textAlign = Paint.Align.CENTER
            textSize = 38.0f
            paint.color = resources.getColor(R.color.colorSecondaryText, null)

        }
        canvas?.drawText(percentText, centerX, centerY+10, textPaint)


    }


}