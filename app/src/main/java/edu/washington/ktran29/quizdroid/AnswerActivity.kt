package edu.washington.ktran29.quizdroid

import android.content.Intent
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
        scoreText.text = "You have $correct out of ${index} correct"

        println(index)

        if (index >= questions.size) nextButton.text = "Finish" else nextButton.text = "Next"

        nextButton.setOnClickListener {
            if (nextButton.text == "Finish") {
                val intent = Intent(this, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                this.startActivity(intent)
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("INDEX", index)
                intent.putExtra("QUESTIONS", questions)
                intent.putExtra("ANSWERS", answers)
                intent.putExtra("CATEGORY", category)
                intent.putExtra("CORRECT", correct)

                this.startActivity(intent)
            }
        }
    }
}
