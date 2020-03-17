package com.example.swipequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Questions>()
    private val viewAdapter = RecyclerViewAdapter(questions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        idRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        idRecyclerView.adapter = viewAdapter
        idRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //Questions
        questions.add(Questions(getString(R.string.valVar), false))
        questions.add(Questions(getString(R.string.ECTS), false))
        questions.add(Questions(getString(R.string.unit), true))
        questions.add(Questions(getString(R.string.whenSwitch), true))

        //val itemTouchHelperCallback = object:
    }

    //private fun
}
