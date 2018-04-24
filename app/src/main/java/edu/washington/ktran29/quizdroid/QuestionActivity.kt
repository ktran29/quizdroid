package edu.washington.ktran29.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_overview.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questions = intent.getStringArrayExtra("QUESTIONS")
        val answers = intent.getStringArrayExtra("ANSWERS")
        var index = intent.getIntExtra("INDEX", 0)
        val category = intent.getStringExtra("CATEGORY")

        supportActionBar?.title = category + " Quiz"

        a1.text = answers[0]
        a2.text = answers[1]
        a3.text = answers[2]
        a4.text = answers[3]


        questionText.text = questions[index]


        submitButton.setOnClickListener {

            index++
            var intent: Intent? = null
            if (index == questions.size) {
                intent = Intent(this, QuestionActivity::class.java)
            } else {

            }

            intent?.putExtra("INDEX", index)
            intent?.putExtra("QUESTIONS", questions)
            intent?.putExtra("ANSWERS", answers)
            intent?.putExtra("CATEGORY", category)
        }


    }
}
