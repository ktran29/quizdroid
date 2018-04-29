package edu.washington.ktran29.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {

    val TAG = "QuestionFragment"

    companion object {
        fun newInstance(): QuestionFragment {
            return QuestionFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val questions = arguments.getStringArray("questions")
        val answers = arguments.getStringArray("answers")
        var correct = arguments.getInt("correct")
        var index = arguments.getInt("index")

        a1.text = answers[0]
        a2.text = answers[1]
        a3.text = answers[2]
        a4.text = answers[3]

        questionText.text = questions[index]

        var selected = 0

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            submitButton.isEnabled = true
            selected = checkedId % 10
        }


        submitButton.setOnClickListener {
            index++

            if (selected == 3) {
                correct++
            }

            val args = Bundle()
            args.putStringArray("questions", questions)
            args.putStringArray("answers", answers)
            args.putInt("index", 0)
            args.putInt("correct", 0)

            val answerFrag = AnswerFragment()
            answerFrag.arguments = args

            loadFragment(answerFrag)

        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
