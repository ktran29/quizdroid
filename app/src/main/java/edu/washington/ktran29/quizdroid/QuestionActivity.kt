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
        var correct = intent.getIntExtra("CORRECT", 0)

        supportActionBar?.title = category + " Quiz"

        a1.text = answers[0]
        a2.text = answers[1]
        a3.text = answers[2]
        a4.text = answers[3]


        questionText.text = questions[index]

        var selected = 0

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            submitButton.isEnabled = true
            selected = checkedId % 10
        }


        submitButton.setOnClickListener {

            index++
            var intent = Intent(this, AnswerActivity::class.java)


            if (selected == 3) {
                correct++
            }

            intent.putExtra("INDEX", index)
            intent.putExtra("QUESTIONS", questions)
            intent.putExtra("ANSWERS", answers)
            intent.putExtra("CATEGORY", category)
            intent.putExtra("CORRECT", correct)
            intent.putExtra("SELECTED", selected)

            this.startActivity(intent)
        }


    }
}
