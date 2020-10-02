package com.balsa.coolquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()

        populateQuestion()

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)
    }

    private fun populateQuestion(){
        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        progress_tv.text = "$mCurrentPosition" + "/" + progressBar.max

        question_tv.text = question!!.question
        answer1.text = question!!.answer1
        answer2.text = question!!.answer2
        answer3.text = question!!.answer3
        answer4.text = question!!.answer4
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, answer1)
        options.add(1, answer2)
        options.add(2, answer3)
        options.add(3, answer4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.answer_option_border)
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNumber: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(Typeface.DEFAULT_BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.answer_option_border_selected)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.answer1 -> {
                selectedOptionView(answer1, 1)
            }
            R.id.answer2 -> {
                selectedOptionView(answer2, 1)
            }
            R.id.answer3 -> {
                selectedOptionView(answer3, 1)
            }
            R.id.answer4 -> {
                selectedOptionView(answer4, 1)
            }
        }
    }
}
