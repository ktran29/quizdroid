package edu.washington.ktran29.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val description = intent.getStringExtra(CustomerViewHolder.DESCRIPTION)
        val category = intent.getStringExtra(CustomerViewHolder.CATEGORY_TITLE_KEY)

        supportActionBar?.title = category + " Quiz"

        descriptionText.text = description

        button.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("INDEX", 0)
            intent.putExtra("CORRECT", 0)

            this.startActivity(intent)
        }

    }
}
