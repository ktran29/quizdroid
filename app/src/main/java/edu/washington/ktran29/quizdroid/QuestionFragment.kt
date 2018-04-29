package edu.washington.ktran29.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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




}
