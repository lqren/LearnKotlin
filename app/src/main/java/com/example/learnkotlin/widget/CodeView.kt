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

/**
 * apply、let、also、run、with都是作用域操作符
 * apply和run作用对象都是this
 * apply:  返回值是谁调用他就返回谁  作用域是this
 * also：返回的是调用的对象 it
 *
 * run:不需要返回值  作用域是this
 * let:不需要返回值  当判断空的时候使用  作用域是it
 */
class CodeView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    AppCompatTextView(context, attr) {

    private val paint = Paint().apply {
       isAntiAlias = true;
       style = Paint.Style.STROKE;
       color = getContext().getColor(R.color.colorAccent);
//        paint.strokeWidth = dp2px(6f);
       strokeWidth = 6f.dp2px();
    }
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

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        gravity = Gravity.CENTER;
        setBackgroundColor(getContext().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        updateCode();
    }


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