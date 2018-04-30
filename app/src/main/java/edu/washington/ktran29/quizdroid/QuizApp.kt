package edu.washington.ktran29.quizdroid

import android.app.Application
import android.util.Log

class QuizApp : Application() {

    private val TAG = "QuizApp"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "QuizApp created")
    }

    companion object {

    }

}

interface TopicRepository {

    data class Topic(val title: String, val shortDesc: String, val longDesc: String, val questions: Collection<Quiz>)

    data class Quiz(val questionText: String, val answers: Array<String>, val correctIndex: Int)

}