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

        val description = arguments.getString("description")
        val questions = arguments.getParcelableArrayList<TopicRepository.Question>("questions")



        descriptionText.text = description
        numberOfQuestions.text = if (questions.size == 0) "There is 1 question" else "There are ${questions.size} questions"

        button.setOnClickListener {
            val args = Bundle()
            args.putInt("index", 0)
            args.putInt("correct", 0)
            args.putParcelableArrayList("questions", questions)

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
