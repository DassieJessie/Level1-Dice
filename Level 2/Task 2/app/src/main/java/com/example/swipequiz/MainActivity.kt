package com.example.swipequiz

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
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

        touchSwipe().attachToRecyclerView(idRecyclerView)

    }

    private fun touchSwipe(): ItemTouchHelper {
        val itemTouchHelperCallback = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                //false because dragDirs = 0
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                when (direction) {
                    ItemTouchHelper.RIGHT ->
                        checkAnswer(position, true)

                    ItemTouchHelper.LEFT ->
                        checkAnswer(position, false)
                }
                //zonder crashed de app wanneer je een item wilt deleten
                viewAdapter.notifyDataSetChanged()

            }

        }

        return ItemTouchHelper(itemTouchHelperCallback)
    }

    private fun checkAnswer(position: Int, right: Boolean){

        if(questions[position].questionBool == right) {
            questions.removeAt(position)
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }
    }
}
