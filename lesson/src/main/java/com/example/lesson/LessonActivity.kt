package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.base.BaseView
import com.example.base.utils.CacheUtils
import com.example.lesson.entity.Lesson
import kotlin.reflect.KProperty

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter?>,
    Toolbar.OnMenuItemClickListener {
    override val presenter: LessonPresenter by lazy {
        //by lazy这里面的代码只会执行一次
        LessonPresenter(this)
    }

/*    var token: String
        set(value) {
            CacheUtils.save("token", value)
        }
        get() {
            return CacheUtils.get("token")!!
        }

    var token2: String
        set(value) {
            CacheUtils.save("token", value)
        }
        get() {
            return CacheUtils.get("token")!!
        }*/


    var token: String by Saver("token")

    class Saver(var token: String) {
        operator fun getValue(lessonActivity: LessonActivity, property: KProperty<*>): String {
            return CacheUtils.get(token)!!
        }

        operator fun setValue(
            lessonActivity: LessonActivity,
            property: KProperty<*>,
            value: String
        ) {
            CacheUtils.save(token, value)
        }
    }


    private val lessonAdapter = LessonAdapter()
    private lateinit var refreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)
        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }


        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).apply{
            setOnRefreshListener { presenter.fetchData() }
            isRefreshing = true
        }

        presenter.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout!!.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        presenter.showPlayback()
        return false
    }

//    override fun getPresenter(): LessonPresenter {
//        return presenter
//    }

}