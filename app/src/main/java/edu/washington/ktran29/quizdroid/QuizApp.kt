package edu.washington.ktran29.quizdroid

import android.app.Application
import android.os.Environment
import android.os.Parcelable
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.json
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray
import java.io.File
import java.io.InputStream

class QuizApp : Application() {

    private val TAG = "QuizApp"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "QuizApp created")

    }

    companion object {
        private var quizzes: ArrayList<TopicRepository.Topic> = arrayListOf()

        fun accessData(): ArrayList<TopicRepository.Topic> = quizzes

        fun loadJSONFromFile() {

            quizzes = arrayListOf()

            val path = "${Environment.getExternalStorageDirectory().path}/Download/questions.json"

            val jsonFile = File(path)

            if (jsonFile.exists()) {
                Log.i("QuizApp", "JSON file exists")

                val inputString = jsonFile.inputStream().bufferedReader().use { it.readText() }

                val jsonArray = JSONArray(inputString)

                for (i in 0..(jsonArray.length() - 1)) {
                    val topic = jsonArray.getJSONObject(i)
                    val title = topic.getString("title")
                    val desc = topic.getString("desc")
                    val jsonQuestions = topic.getJSONArray("questions")

                    val questions = arrayListOf<TopicRepository.Question>()
                    for (j in 0..(jsonQuestions.length() - 1)) {
                        val question = jsonQuestions.getJSONObject(j)
                        val text = question.getString("text")
                        val answer = question.getString("answer").toInt()
                        val jsonAnswers = question.getJSONArray("answers")
                        var answers = arrayListOf<String>()
                        for (k in 0..(jsonAnswers.length() - 1)) {
                            answers.add(jsonAnswers.getString(k))
                        }
                        questions.add(TopicRepository.Question(text, answers, answer - 1))
                    }

                    quizzes.add(TopicRepository.Topic(title, desc, desc, questions))
                }

            } else {
                Log.d("quizApp", "JSON File doesn't exist")
            }
        }

    }

}

interface TopicRepository {
    
    data class Topic(val title: String, val shortDesc: String, val longDesc: String, val questions: ArrayList<Question>)

    @Parcelize
    data class Question(val questionText: String?, val answers: ArrayList<String>?, val correctIndex: Int?): Parcelable

}
