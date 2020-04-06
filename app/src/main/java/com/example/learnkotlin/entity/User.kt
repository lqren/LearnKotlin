package com.example.learnkotlin.entity
//data class 功能：
//      1、语法糖，会自动生成hashcode、equals、copy方法
//      2、解构：
data class User constructor(var username: String?, var password: String?, var code: String?) {
//    @JvmField   //生成一个公开的成员变量，可以在Java当中直接通过实例.的方式访问该属性，不会生成set()/get()
//    var username: String? = null
////    var password: String? = null
////    var code: String? = null

    constructor():this(null,null,null)
}