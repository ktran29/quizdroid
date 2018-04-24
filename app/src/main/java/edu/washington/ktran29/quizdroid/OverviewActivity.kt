package edu.washington.ktran29.quizdroid

import android.content.Intent
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
        val category = intent.getStringExtra(CustomerViewHolder.CATEGORY_TITLE_KEY)

        supportActionBar?.title = category + "Quiz"

        descriptionText.text = description
        numberOfQuestions.text = "There are ${questions.size} questions"

        button.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("INDEX", 0)
            intent.putExtra("QUESTIONS", questions)
            intent.putExtra("ANSWERS", answers)
            intent.putExtra("CATEGORY", category)
            intent.putExtra("CORRECT", 0)

            this.startActivity(intent)
        }

    }
}
