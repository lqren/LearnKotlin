package com.example.base

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import java.util.*
//kotlin当中默认类都不能被继承，方法都不能被重写，除非被abstract修饰或者是open关键字 override子类才能重写或继承
abstract class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View?> =
        HashMap()

    protected open fun <T : View?> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T?
    }

    protected open fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}