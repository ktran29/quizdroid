package edu.washington.ktran29.quizdroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.quiz_row.view.*
import java.io.Serializable

/**
 * Created by kevintran on 4/23/18.
 */
class MainAdapter: RecyclerView.Adapter<CustomerViewHolder>() {

    private val quizCategories = listOf("Math", "Physics", "Marvel Super Heroes")
    private val questions = arrayOf(arrayOf("What is 2 + 2?", "What is 2 + 2?"), arrayOf("E = ?"), arrayOf("Who is the best?"))
    private val mathAnswers = arrayOf("1", "2", "3", "4")
    private val scienceAnswers = arrayOf("A", "B", "C", "MC^2")
    private val heroAnswers = arrayOf("Iron Man", "Captain America", "Batman", "Spiderman")
    private val answers = arrayOf(mathAnswers, scienceAnswers, heroAnswers)
    private val descriptions = arrayOf("This is about math", "This is about physics", "This is about super heroes")

    override fun onBindViewHolder(holder: CustomerViewHolder?, position: Int) {
        holder?.view?.categoryName?.text = quizCategories[position]

        holder?.categoryName = quizCategories[position]
        holder?.questions = questions[position]
        holder?.answers = answers[position]
        holder?.description = descriptions[position]

    }

    override fun getItemCount(): Int {
        return quizCategories.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.quiz_row, parent, false)
        return CustomerViewHolder(cellForRow)
    }

}

class CustomerViewHolder(val view: View, var categoryName: String? = null, var questions: Array<String>? = null,
                         var answers: Array<String>? = null, var description: String? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val CATEGORY_TITLE_KEY = "CATEGORY TITLE"
        val QUESTIONS = "QUESTIONS"
        val ANSWERS = "ANSWERS"
        val DESCRIPTION = "DESCRIPTION"
    }

    init {
        view.setOnClickListener {

            val intent = Intent(view.context, QuizActivity::class.java)

            intent.putExtra(CATEGORY_TITLE_KEY, categoryName)
            intent.putExtra(QUESTIONS, questions)
            intent.putExtra(ANSWERS, answers)
            intent.putExtra(DESCRIPTION, description)

            view.context.startActivity(intent)
        }
    }
}