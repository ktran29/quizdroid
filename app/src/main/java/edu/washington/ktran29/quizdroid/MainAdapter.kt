package edu.washington.ktran29.quizdroid

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

    private val quizzes: ArrayList<TopicRepository.Topic> = arrayListOf()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        makeMathData()
        makePhysicsData()
        makeHeroData()

    }


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

    private fun makeMathData() {
        val question1 = TopicRepository.Question("What is 1 + 1?", arrayListOf("1", "2", "3", "4"), 0)
        val question2 = TopicRepository.Question("What is 2 + 2?", arrayListOf("1", "2", "3", "4"), 3)
        val questions = arrayListOf<TopicRepository.Question>()
        questions.add(question1)
        questions.add(question2)
        val topic = TopicRepository.Topic("Math", "Math Quiz", "This is about math", questions)
        quizzes.add(topic)
    }

    private fun makePhysicsData() {
        val question = TopicRepository.Question("E=?", arrayListOf("Gravity", "Mechanics", "MC^2", "Light"), 2)
        val questions = arrayListOf<TopicRepository.Question>()
        questions.add(question)
        val topic = TopicRepository.Topic("Physics", "Physics Quiz", "This is about physics", questions)
        quizzes.add(topic)
    }

    private fun makeHeroData() {
        val question = TopicRepository.Question("Who's the best hero?", arrayListOf("Spider Man", "Iron Man", "Hawkeye", "Deadpool"), 1)
        val questions = arrayListOf<TopicRepository.Question>()
        questions.add(question)
        val topic = TopicRepository.Topic("Marvel Heroes", "Heroes Quiz", "This is about marvel super heroes", questions)
        quizzes.add(topic)
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