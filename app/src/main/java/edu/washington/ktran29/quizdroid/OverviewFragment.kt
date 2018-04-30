package edu.washington.ktran29.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_overview.*

class OverviewFragment : Fragment() {

    val TAG = "OverviewFragment"

    companion object {
        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val questions = arguments.getStringArray("questions")
        val answers = arguments.getStringArray("answers")
        val description = arguments.getString("description")


        descriptionText.text = description

        if (questions.size == 1) {
            numberOfQuestions.text = "There is 1 question."
        } else {
            numberOfQuestions.text = "There are ${questions.size} questions."
        }

        button.setOnClickListener {
            val args = Bundle()
            args.putStringArray("questions", questions)
            args.putStringArray("answers", answers)
            args.putInt("index", 0)
            args.putInt("correct", 0)

            val questionFrag = QuestionFragment()
            questionFrag.arguments = args

            loadFragment(questionFrag)


        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom)
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}
