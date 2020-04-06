package com.example.learnkotlin

class View {
    interface OnClickListener {
        fun onClick(view: View)
    }

    //函数类型   由一个函数接收类型和返回的类型组成  中间由->组成
    fun setOnClickListener(listener:(View)->Unit){

    }
}

fun main() {
    val view = View()
    //传递函数引用
//    view.setOnClickListener(::onClick)
    //匿名函数
    view.setOnClickListener{
        println("被点击了")
    }
}

fun onClick(view: View){
    println("被点击了")
}