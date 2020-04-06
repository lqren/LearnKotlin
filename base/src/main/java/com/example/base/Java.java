package com.example.base;

import com.example.base.utils.KotlinUtils;
import com.example.base.utils.Utils;

public class Java {
    public static void main(String[] args) {
        //Java中调用写在Kotlin文件中的方法
//        UtilsKt.dp2px(6f);

        //如果静态方法是通过object的方式声明的，那么需要通过类名.INSTANCE的方式去调用
        Utils.INSTANCE.toast("heihei");

        //java中调用kotlin中伴生对象创建的静态方法
        BaseApplication.Companion.currentApplication();
        KotlinUtils.dp2px(6f);

        //当方法被@JvmStatic所修饰的时候，就可以直接通过类名.的方式调用
//        BaseApplication.currentApplication();
    }
}
