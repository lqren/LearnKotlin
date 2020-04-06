package com.example.lesson.entity

class Lesson {
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

     var date: String? = null
     var content: String? = null
     var state: State? = null

    constructor(date: String?, content: String?, state: State?) {
        this.date = date
        this.content = content
        this.state = state
    }
}