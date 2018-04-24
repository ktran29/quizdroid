package edu.washington.ktran29.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)


        val questions = intent.getStringArrayExtra("QUESTIONS")
        val answers = intent.getStringArrayExtra("ANSWERS")
        var index = intent.getIntExtra("INDEX", 0)
        val category = intent.getStringExtra("CATEGORY")
        var correct = intent.getIntExtra("CORRECT", 0)
        var selected = intent.getIntExtra("SELECTED", 0)

        supportActionBar?.title = category + " Quiz"

        selectedText.text = "You selected ${answers[selected]}"
        correctText.text = "The correct answer was ${answers[3]}"
        scoreText.text = "You have $correct out of ${questions.size} correct"

        if (index >= questions.size) nextButton.text = "Finish" else nextButton.text = "Next"
    }
}
