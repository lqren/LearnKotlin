package com.example.learnkotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.base.utils.dp2px
import com.example.learnkotlin.R
import java.util.*

class CodeView : AppCompatTextView {
    constructor(context: Context) : this(context, null) {
    }

    constructor(context: Context, attr: AttributeSet?) : super(context, attr) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        gravity = Gravity.CENTER;
        setBackgroundColor(getContext().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        paint.isAntiAlias = true;
        paint.style = Paint.Style.STROKE;
        paint.color = getContext().getColor(R.color.colorAccent);
        paint.strokeWidth = dp2px(6f);
        updateCode();
    }

    private val paint = Paint()
    private val codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okhttp",
        "retrofit",
        "tcp/ip"
    )

    fun updateCode() {
//     arrayOf()  对于基本数据类型里面装的都是包装类型，所以如果存放的是基本数据类型，会有拆箱装箱的操作，会造成额外的开销，所以对于基本数据类型，我们会使用基本类型对应的集合：例如：
//     intArrayOf()、floatArrayOf()
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint);
        super.onDraw(canvas);
    }
}