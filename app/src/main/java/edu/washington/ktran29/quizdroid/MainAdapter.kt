package edu.washington.ktran29.quizdroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.quiz_row.view.*

/**
 * Created by kevintran on 4/23/18.
 */
class MainAdapter: RecyclerView.Adapter<CustomerViewHolder>() {

    private val quizCategories = listOf("Math", "Physics", "Marvel Super Heroes")

    override fun onBindViewHolder(holder: CustomerViewHolder?, position: Int) {
        holder?.view?.categoryName?.text = quizCategories[position]

    }

    override fun getItemCount(): Int {
        return quizCategories.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.quiz_row, parent, false)
        return CustomerViewHolder(cellForRow)
    }

}

class CustomerViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}