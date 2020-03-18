package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_logica_app.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica_app)

        //click on confirm
        btnConfirm.setOnClickListener{
            onClickConfirm()
        }
    }

    private fun onClickConfirm() {
        correctAnswers = 0
        checkAnswers()
        Toast.makeText(this,  getString(R.string.correctNumAnswers, correctAnswers), Toast.LENGTH_LONG).show()
    }

    private fun checkAnswers(){
        if (idAnswer1.text.toString() == "T" || idAnswer1.text.toString() == "t") correctAnswer()
        if (idAnswer2.text.toString() == "F" || idAnswer2.text.toString() == "f") correctAnswer()
        if (idAnswer3.text.toString() == "F" || idAnswer3.text.toString() == "f") correctAnswer()
        if (idAnswer4.text.toString() == "F" || idAnswer4.text.toString() == "f") correctAnswer()
    }

    private fun correctAnswer(){
        correctAnswers++
    }

}
