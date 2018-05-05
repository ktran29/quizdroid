package edu.washington.ktran29.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
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

        val questions = arguments.getParcelableArrayList<TopicRepository.Question>("questions")
        var correct = arguments.getInt("correct")
        var index = arguments.getInt("index")

        val currentQuestion = questions[index]

        Log.d(TAG, "${currentQuestion.answers?.size}")

        a1.text = currentQuestion.answers?.get(0)
        a2.text = currentQuestion.answers?.get(1)
        a3.text = currentQuestion.answers?.get(2)
        a4.text = currentQuestion.answers?.get(3)

        questionText.text = currentQuestion.questionText

        var selected = 0

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            submitButton.isEnabled = true
            selected = checkedId % 10
        }


        submitButton.setOnClickListener {

            if (selected == currentQuestion.correctIndex) {
                correct++
            }

            val args = Bundle()
            args.putParcelableArrayList("questions", questions)
            args.putInt("index", index)
            args.putInt("correct", correct)
            args.putInt("selected", selected)

            val answerFrag = AnswerFragment()
            answerFrag.arguments = args

            loadFragment(answerFrag)

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
