package com.example.base.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

object HttpClient : OkHttpClient() {
    val gson: Gson = Gson();

    private fun <T> convert(json: String?, type: Type): T {
        return gson.fromJson(json, type);
    }

    fun <T> get(path:String,type:Type,entityCallBack:EntityCallback<T>){
        val request:Request = Request.Builder()
            .url("https://api.hencoder.com/$path")
            .build()
        val call = newCall(request)
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                entityCallBack.onFailure("网络异常")

            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> entityCallBack.onSuccess(convert(response.body()!!.string(), type));
                    in 400..499 -> entityCallBack.onFailure("客户端错误");
                    in 500..599 -> entityCallBack.onFailure("服务器错误");
                    else -> entityCallBack.onFailure("未知错误");
                }
            }

        })
    }

}