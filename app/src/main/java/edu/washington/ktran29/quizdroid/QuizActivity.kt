package edu.washington.ktran29.quizdroid

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizActivity : AppCompatActivity() {

    private val TAG = "QuizActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var overviewFrag = OverviewFragment()

        val description = intent.getStringExtra(CustomerViewHolder.DESCRIPTION)
        val category = intent.getStringExtra(CustomerViewHolder.CATEGORY_TITLE_KEY)
        val questions = intent.getParcelableArrayListExtra<TopicRepository.Question>(CustomerViewHolder.QUESTIONS)

        supportActionBar?.title = "$category Quiz"

        val args = Bundle()
        args.putString("description", description)
        args.putString("category", category)
        args.putParcelableArrayList("questions", questions)
        overviewFrag.arguments = args

        loadFragment(overviewFrag)

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
