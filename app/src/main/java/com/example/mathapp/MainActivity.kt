package com.example.mathapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivity: ConstraintLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var selectView: TextView
    private lateinit var questionView: TextView
    private lateinit var answerView: EditText
    private lateinit var answerButton: Button
    private lateinit var additionButton: Button
    private lateinit var subtractionButton: Button
    private lateinit var multiplicationButton: Button
    private lateinit var divisionButton: Button
    private lateinit var resultCardView: CardView
    private lateinit var resultView: TextView

    var correctAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //===== CONNECT WITH XML FILE =====
        mainActivity = findViewById(R.id.main)
        selectView = findViewById(R.id.selectView)
        questionView = findViewById(R.id.questionView)
        answerView = findViewById(R.id.answerView)
        answerButton = findViewById(R.id.answerButton)

        additionButton = findViewById(R.id.additionButton)
        subtractionButton = findViewById(R.id.subtractionButton)
        multiplicationButton = findViewById(R.id.multiplicationButton)
        divisionButton = findViewById(R.id.divisionButton)

        resultCardView = findViewById(R.id.resultCardView)
        resultView = findViewById(R.id.resultView)


        //===== BUTTON FUNCTIONS =====

        additionButton.setOnClickListener {
            setNewAdditionCalculation()

            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", 0f)
            animatorY.duration = 500
            animatorY.start()

            resultView.text = ""
            answerView.text.clear()

            resultCardView.visibility = View.INVISIBLE

            when (tabLayout.selectedTabPosition) {
                0 -> { resultView.setBackgroundColor(resources.getColor(R.color.black, theme)) }
                1 -> { resultView.setBackgroundColor(resources.getColor(R.color.light_orange, theme)) }
                2 -> { resultView.setBackgroundColor(resources.getColor(R.color.indigo, theme)) }
            }
        }

        subtractionButton.setOnClickListener {
            setNewSubtractionCalculation()

            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", 0f)
            animatorY.duration = 500
            animatorY.start()

            resultView.text = ""
            answerView.text.clear()

            resultCardView.visibility = View.INVISIBLE

            when (tabLayout.selectedTabPosition) {
                0 -> { resultView.setBackgroundColor(resources.getColor(R.color.black, theme)) }
                1 -> { resultView.setBackgroundColor(resources.getColor(R.color.light_orange, theme)) }
                2 -> { resultView.setBackgroundColor(resources.getColor(R.color.indigo, theme)) }
            }
        }

        multiplicationButton.setOnClickListener {
            setNewMultiplicationCalculation()

            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", 0f)
            animatorY.duration = 500
            animatorY.start()

            resultView.text = ""
            answerView.text.clear()

            resultCardView.visibility = View.INVISIBLE

            when (tabLayout.selectedTabPosition) {
                0 -> { resultView.setBackgroundColor(resources.getColor(R.color.black, theme)) }
                1 -> { resultView.setBackgroundColor(resources.getColor(R.color.light_orange, theme)) }
                2 -> { resultView.setBackgroundColor(resources.getColor(R.color.indigo, theme)) }
            }
        }

        divisionButton.setOnClickListener {
            setNewDivisionCalculation()

            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", 0f)
            animatorY.duration = 500
            animatorY.start()

            resultView.text = ""
            answerView.text.clear()

            resultCardView.visibility = View.INVISIBLE


            when (tabLayout.selectedTabPosition) {
                0 -> { resultView.setBackgroundColor(resources.getColor(R.color.black, theme)) }
                1 -> { resultView.setBackgroundColor(resources.getColor(R.color.light_orange, theme)) }
                2 -> { resultView.setBackgroundColor(resources.getColor(R.color.indigo, theme)) }
            }
        }


        answerButton.setOnClickListener {
            handleAnswer()
        }

        tabLayout = findViewById(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    // DARK THEME
                    0 -> {
                        mainActivity.setBackgroundColor(resources.getColor(R.color.black, theme))
                        tabLayout.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                        additionButton.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                        subtractionButton.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                        multiplicationButton.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                        divisionButton.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                        answerButton.setBackgroundColor(resources.getColor(R.color.dark_grey, theme))
                    }
                    // LIGHT THEME
                    1 -> {
                        mainActivity.setBackgroundColor(resources.getColor(R.color.light_orange, theme))
                        tabLayout.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        additionButton.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        subtractionButton.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        multiplicationButton.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        divisionButton.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        answerButton.setBackgroundColor(resources.getColor(R.color.turquoise, theme))
                        }
                    // COLOR THEME
                    2 -> {
                        mainActivity.setBackgroundColor(resources.getColor(R.color.indigo, theme))
                        tabLayout.setBackgroundColor(resources.getColor(R.color.pink, theme))
                        additionButton.setBackgroundColor(resources.getColor(R.color.red, theme))
                        subtractionButton.setBackgroundColor(resources.getColor(R.color.orange, theme))
                        multiplicationButton.setBackgroundColor(resources.getColor(R.color.yellow, theme))
                        divisionButton.setBackgroundColor(resources.getColor(R.color.green, theme))
                        answerButton.setBackgroundColor(resources.getColor(R.color.blue, theme))
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    // ===== HANDLE THE ANSWER =====
    fun handleAnswer() {
        val answeredCorrect = checkAnswer()

        if (answeredCorrect) {
            resultCardView.visibility = View.VISIBLE

            resultView.setBackgroundColor(resources.getColor(R.color.green, theme))
            resultView.text = getString(R.string.correct_answer_text)
            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", -400f)
            animatorY.duration = 500
            animatorY.start()

        } else {
            resultCardView.visibility = View.VISIBLE

            resultView.setBackgroundColor(resources.getColor(R.color.red, theme))
            resultView.text = getString(R.string.wrong_answer_text)

            val animatorY = ObjectAnimator.ofFloat(resultCardView, "translationY", -400f)
            animatorY.duration = 500
            animatorY.start()
        }

// ANVÄNDS EJ NÄR JAG EJ BYTER ACTIVITY

        //        val intent = Intent(this, AnswerActivity::class.java)
        //        intent.putExtra("answeredCorrect", answeredCorrect)
        //
        //        startActivity(intent)

    }

    // ===== CHECKING THE ANSWER =====
    fun checkAnswer(): Boolean {

        val answerText = answerView.text.toString()
        val answer = answerText.toIntOrNull()

        return answer == correctAnswer
    }

    // ===== ADDITION CALCULATION =====
    fun setNewAdditionCalculation() {
        val firstNumber = (1..500).random()
        val secondNumber = (1..500).random()

        correctAnswer = firstNumber + secondNumber

        questionView.text = "$firstNumber + $secondNumber ="
    }


    // ===== SUBTRACTION CALCULATION =====
    fun setNewSubtractionCalculation() {
        val firstNumber = (1..1000).random()
        val secondNumber = (1..firstNumber).random()

        correctAnswer = firstNumber - secondNumber

        questionView.text = "$firstNumber - $secondNumber ="
    }

    // ===== MULTIPLICATION CALCULATION =====
    fun setNewMultiplicationCalculation() {
        val firstNumber = (1..500).random()
        val secondNumber = (2..10).random()

        correctAnswer = firstNumber * secondNumber

        questionView.text = "$firstNumber x $secondNumber ="
    }

    // ===== DIVISION CALCULATION =====
    fun setNewDivisionCalculation() {
        val randomNumber = (2..10).random()

        var firstNumber = 0
        var secondNumber = 0

        when (randomNumber) {
            2 -> {
                firstNumber = divByTwo()
                secondNumber = 2
            }

            3 -> {
                firstNumber = divByThree()
                secondNumber = 3
            }

            4 -> {
                firstNumber = divByFour()
                secondNumber = 4
            }

            5 -> {
                firstNumber = divByFive()
                secondNumber = 5
            }

            6 -> {
                firstNumber = divBySix()
                secondNumber = 6
            }

            7 -> {
                firstNumber = divBySeven()
                secondNumber = 7
            }

            8 -> {
                firstNumber = divByEight()
                secondNumber = 8
            }

            9 -> {
                firstNumber = divByNine()
                secondNumber = 9
            }

            10 -> {
                firstNumber = divByTen()
                secondNumber = 10
            }
        }
        correctAnswer = firstNumber / secondNumber

        questionView.text = "$firstNumber / $secondNumber ="
    }


    // ===== DIVISION FUNCTIONS: 2 to 10 =====
    fun divByTwo(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 499) {
            i += 2
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByThree(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 333) {
            i += 3
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByFour(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 250) {
            i += 4
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByFive(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 200) {
            i += 5
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divBySix(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 166) {
            i += 6
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divBySeven(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 142) {
            i += 7
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByEight(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 125) {
            i += 8
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByNine(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 111) {
            i += 9
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

    fun divByTen(): Int {
        val numberList = mutableListOf<Int>()

        var count = 1
        var i = 0
        while (count <= 100) {
            i += 10
            numberList.add(i)
            count++
        }

        return numberList.random()
    }

}