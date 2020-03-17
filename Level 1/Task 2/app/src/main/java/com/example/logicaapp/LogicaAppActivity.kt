package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_logica_app.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica_app)

        //click on confirm
        btnConfirm.setOnClickListener{
            onClickConfirm()
        }
    }

    private fun onClickConfirm() {
        Toast.makeText(this,  getString(R.string.test), Toast.LENGTH_LONG).show()
    }
}
