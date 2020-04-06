package com.example.base

interface BaseView<T> {
//    fun getPresenter(): T
    //抽象属性
    open val presenter:T
}