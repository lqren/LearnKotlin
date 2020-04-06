package com.example.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    companion object {
        @JvmStatic
        @get:JvmName("currentApplication")
         lateinit var currentApplication: Context

        //@JvmStatic  //只有外面被object修饰才有用  会生成一个真正的静态方法
//        fun currentApplication(): Context {
//            return currentApplication
//        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}