package edu.washington.ktran29.quizdroid

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.quiz_row.view.*

/**
 * Created by kevintran on 4/23/18.
 */
class MainAdapter: RecyclerView.Adapter<CustomerViewHolder>() {

    private val TAG = "MainAdapter"
    private val quizApp: QuizApp.Companion = QuizApp.Companion
    private var quizzes: ArrayList<TopicRepository.Topic> = quizApp.accessData()
    

    override fun onBindViewHolder(holder: CustomerViewHolder?, position: Int) {
        holder?.view?.categoryName?.text = quizzes[position].title
        holder?.view?.categoryShortDesc?.text = quizzes[position].shortDesc
        holder?.topic = quizzes[position]

    }

    override fun getItemCount(): Int {
        return quizzes.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.quiz_row, parent, false)
        return CustomerViewHolder(cellForRow)
    }


}

class CustomerViewHolder(val view: View, var topic: TopicRepository.Topic? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val CATEGORY_TITLE_KEY = "CATEGORY TITLE"
        val QUESTIONS = "QUESTIONS"
        val DESCRIPTION = "DESCRIPTION"
    }

    init {
        view.setOnClickListener {

            val intent = Intent(view.context, QuizActivity::class.java)

            intent.putExtra(CATEGORY_TITLE_KEY, topic?.title)
            intent.putExtra(QUESTIONS, topic?.questions)
            intent.putExtra(DESCRIPTION, topic?.longDesc)

            view.context.startActivity(intent)
        }
    }
}