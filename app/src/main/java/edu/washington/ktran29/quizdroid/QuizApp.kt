package edu.washington.ktran29.quizdroid

import android.app.Application
import android.os.Environment
import android.os.Parcelable
import android.support.v4.content.ContextCompat
import android.util.Log
import com.beust.klaxon.Klaxon
import kotlinx.android.parcel.Parcelize
import java.io.File
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import java.io.InputStream

class QuizApp : Application() {

    private val TAG = "QuizApp"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "QuizApp created")

    }

    companion object: TopicRepository {
        val quizzes: ArrayList<TopicRepository.Topic> = arrayListOf()

        fun accessData(): ArrayList<TopicRepository.Topic> = quizzes

    }

}

interface TopicRepository {

    fun loadJSONFromFile() {

        val path = "${Environment.getExternalStorageDirectory().path}/Download/questions.json"

        val jsonFile = File(path)

        if (jsonFile.exists()) {
            Log.d("QuizApp", "JSON file exists")

            val inputStream: InputStream = jsonFile.inputStream()

            val inputString = inputStream.bufferedReader().use { it.readText() }

            val file = Klaxon().parseArray<Object>(inputString)
            Log.d("QuizAPP","yes")
            Log.d("QUizApp", "$inputString")
            Log.d("QuizApp", "$file")
            Log.d("quizApp","no")
        } else {
            Log.d("QuizApp", "JSON file does not exist")
        }
    }

    data class Topic(val title: String, val shortDesc: String, val longDesc: String, val questions: ArrayList<Question>)

    @Parcelize
    data class Question(val questionText: String?, val answers: ArrayList<String>?, val correctIndex: Int?): Parcelable

}
