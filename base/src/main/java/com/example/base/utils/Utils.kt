@file:JvmName("KotlinUtils")
package com.example.base.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.base.BaseApplication

/**
 *
private static final DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();

public static float dp2px(float dp) {
return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
}

public static void toast(String string) {
toast(string, Toast.LENGTH_SHORT);
}

public static void toast(String string, int duration) {
Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
}
 * kotlin中三种方式定义静态函数
 *      1、直接在kotlin文件中写方法，在kotlin中调用时直接调用导包就可以，在Java中使用时，需要"文件名Kt.方法名"的方式调用
 *      2、直接将该类改成object修饰，就可以直接通过类名.的方式调用  注意：这个并不是直接静态方法，而是生成类的一个对应的单例对象，调用里面的属性和方法都是通过单例对象调用的
 *      3、BaseApplication的单例是FrameWork层创建的，所以我们不能采用第二种方式，因此我们采用伴生对象的方式创建
 */
object Utils {
    fun toast(string:String) {
        toast(string, Toast.LENGTH_SHORT);
    }

    fun toast(string:String , duration:Int) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
    }
}

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics
fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}