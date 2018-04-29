package edu.washington.ktran29.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_answer.*


class AnswerFragment : Fragment() {

    companion object {
        fun newInstance(): AnswerFragment {
            return AnswerFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val questions = arguments.getStringArray("questions")
        val answers = arguments.getStringArray("answers")
        val selected = arguments.getInt("selected")
        val correct = arguments.getInt("correct")
        val index = arguments.getInt("index")

        selectedText.text = "You selected ${answers[selected]}"
        correctText.text = "The correct answer was ${answers[3]}"
        scoreText.text = "You have $correct out of $index correct"

        if (index >= questions.size) nextButton.text = "Finish" else nextButton.text = "Next"

        nextButton.setOnClickListener {
            if (nextButton.text == "Finish") {
                val intent = Intent(activity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                this.startActivity(intent)
            } else {
                val args = Bundle()
                args.putStringArray("questions", questions)
                args.putStringArray("answers", answers)
                args.putInt("index", index)
                args.putInt("correct", correct)

                val questionFrag = QuestionFragment()
                questionFrag.arguments = args

                loadFragment(questionFrag)

            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
