package com.example.lesson.entity

class Lesson  constructor(var date: String?, var content: String?, var state: State?){
//    var date: String? = date
//    var content: String? = content
//    var state: State? = state

//    init{
//        this.date = date
//        this.content = content
//        this.state = state
//    }
    //enum class表示是一个特殊的class
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }


}