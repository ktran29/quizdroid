package edu.washington.ktran29.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val questions = intent.getStringArrayExtra(CustomerViewHolder.QUESTIONS)
        val answers = intent.getSerializableExtra(CustomerViewHolder.ANSWERS)
        val description = intent.getStringExtra(CustomerViewHolder.DESCRIPTION)

        supportActionBar?.title = intent.getStringExtra(CustomerViewHolder.CATEGORY_TITLE_KEY) + "Quiz"

        descriptionText.text = description
        numberOfQuestions.text = "There are ${questions.size} questions"

        button.setOnClickListener {
            println("Hello")
        }

    }
}
