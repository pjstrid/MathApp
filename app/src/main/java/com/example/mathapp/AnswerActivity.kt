package com.example.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class AnswerActivity : AppCompatActivity() {

    private lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        resultView = findViewById(R.id.resultAnswerView)
        val backButton = findViewById<Button>(R.id.backButton)

        val answer = intent.getBooleanExtra("answeredCorrect", false)

        if (answer) {
            resultView.text = getString(R.string.correct_answer_text)
        } else {
            resultView.text = getString(R.string.wrong_answer_text)
        }

        backButton.setOnClickListener {
            finish()
        }

    }
}