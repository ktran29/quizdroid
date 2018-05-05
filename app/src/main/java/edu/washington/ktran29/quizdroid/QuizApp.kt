package edu.washington.ktran29.quizdroid

import android.app.Application
import android.os.Parcelable
import android.util.Log
import kotlinx.android.parcel.Parcelize

class QuizApp : Application() {

    private val TAG = "QuizApp"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "QuizApp created")
    }

    companion object {
        val quizzes: ArrayList<TopicRepository.Topic> = arrayListOf()

        fun accessData(): ArrayList<TopicRepository.Topic> = quizzes
    }

}

interface TopicRepository {

    data class Topic(val title: String, val shortDesc: String, val longDesc: String, val questions: ArrayList<Question>)

    @Parcelize
    data class Question(val questionText: String?, val answers: ArrayList<String>?, val correctIndex: Int?): Parcelable

}
