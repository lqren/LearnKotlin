package com.example.lesson

import com.example.base.http.EntityCallback
import com.example.base.http.HttpClient.get
import com.example.base.utils.Utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class LessonPresenter {

    companion object{
        //编译器常量
        const val LESSON_PATH="lessons"
    }

    private var activity: LessonActivity? = null

    constructor(activity: LessonActivity?) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()
    private val type: Type =
        object : TypeToken<List<Lesson?>?>() {}.getType()

    fun fetchData() {
        get(
            LESSON_PATH,
            type,
            object : EntityCallback<MutableList<Lesson>> {
                override fun onSuccess(lessons: MutableList<Lesson>) {
                    this@LessonPresenter.lessons = lessons
                    activity!!.runOnUiThread(Runnable { activity!!.showResult(lessons) })
                }

                override fun onFailure(message: String) {
                    activity!!.runOnUiThread(Runnable { toast(message!!) })
                }
            })
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity!!.showResult(playbackLessons)
    }
}