package com.example.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.base.utils.CacheUtils
import com.example.base.utils.Utils
import com.example.learnkotlin.entity.User
import com.example.learnkotlin.widget.CodeView
import com.example.lesson.LessonActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val userNameKey = "userName"
    private val passwordKey = "password"

    //?表示可空类型，
    //lateinit 会晚一点初始化，在使用之前一定会初始化，如果没初始化，还是期望在使用时抛出异常
    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(userNameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btn_login = findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)
        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
        val userName = et_username.text.toString()
        val passWord = et_password.text.toString()
        val code = et_code.text.toString()
        val user = User(userNameKey, userName, code)
        if (verify(user)) {
            CacheUtils.save(userNameKey, userName)
            CacheUtils.save(passwordKey, passWord)
            //:class.java  java当中的class
            startActivity(Intent(this, LessonActivity::class.java))
        }

    }

    //如果函数只有一个地方被调用，也为了防止其他地方调用，可以将这个函数放到调用他的函数里面去  内部函数是可以直接访问外部函数的属性的
    //需要注意的是：函数嵌套的时候，被调用会生成额外的对象。要防止频繁调用函数，需要考虑性能问题
    private fun verify(user: User): Boolean {

//        if (user.username == null || user.username!!.length < 4) {
        //如果user是空则直接赋值成0，如果不为空，则取他的length与4进行比较
        if (user.username?.length ?: 0 < 4) {

            Utils.toast("用户名不合法")
            return false
        }

//        if (user.password == null || user.password!!.length < 4) {
        if (user.password?.length ?: 0 < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}
