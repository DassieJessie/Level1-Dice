package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_higher_lower.*
import android.widget.Toast

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)

        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        btnHigher.setOnClickListener{
            onHigherClick()
        }
        btnEquals.setOnClickListener{
            onEqualClick()
        }
        btnLower.setOnClickListener{
            onLowerClick()
        }

        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        idLastThrow.text = getString(R.string.last_throw, lastThrow)


        // (met hulp)
        when (currentThrow){
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    /**
     * Replaces the previous dice value with the current one and replaces the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }


    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) onAnswerCorrect()
            else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()

        if (currentThrow == lastThrow) onAnswerCorrect()
            else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) onAnswerCorrect()
            else onAnswerIncorrect()
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this,  getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this,  getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }





}
