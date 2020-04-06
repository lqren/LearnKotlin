package com.example.learnkotlin.entity

class User : Any {
    @JvmField   //生成一个公开的成员变量，可以在Java当中直接通过实例.的方式访问该属性，不会生成set()/get()
    var username: String? = null
    var password: String? = null
    var code: String? = null

    constructor() {}
    constructor(username: String?, password: String?, code: String?) {
        this.username = username
        this.password = password
        this.code = code
    }
}