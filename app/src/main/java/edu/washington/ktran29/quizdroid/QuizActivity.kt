package edu.washington.ktran29.quizdroid

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {

    var fragmentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var overviewFrag = OverviewFragment()

        val questions = intent.getStringArrayExtra(CustomerViewHolder.QUESTIONS)
        val answers = intent.getStringArrayExtra(CustomerViewHolder.ANSWERS)
        val description = intent.getStringExtra(CustomerViewHolder.DESCRIPTION)
        val category = intent.getStringExtra(CustomerViewHolder.CATEGORY_TITLE_KEY)

        supportActionBar?.title = "$category Quiz"

        val args = Bundle()
        args.putStringArray("questions", questions)
        args.putStringArray("answers", answers)
        args.putString("description", description)
        args.putString("category", category)
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
