package com.balsa.coolquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mUserName:String? = null
    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mChooseQuestion:Boolean = false //To tell if user already pressed sumbit for this question
    private var mCorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        populateQuestion()

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)
        submit.setOnClickListener(this)

    }

    private fun populateQuestion(){
//        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        progress_tv.text = "$mCurrentPosition" + "/" + progressBar.max

        question_tv.text = question!!.question
        answer1.text = question!!.answer1
        answer2.text = question!!.answer2
        answer3.text = question!!.answer3
        answer4.text = question!!.answer4
        if(mCurrentPosition > mQuestionsList!!.size){
            submit.text = "Finish"
        }else{
            submit.text = "Submit"
        }
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
        if(!mChooseQuestion) {
            defaultOptionsView()
            mSelectedOptionPosition = selectedOptionNumber

            textView.setTextColor(Color.parseColor("#363A43"))
            textView.typeface = Typeface.DEFAULT_BOLD
            textView.background = ContextCompat.getDrawable(this, R.drawable.answer_option_border_selected)
        }
    }

    //This method gets number of selected answer and background to set for it
    private fun answerView(answer: Int, drawableView: Int) {
        when(answer){
            1 -> {
                answer1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                answer2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                answer3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                answer4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.answer1 -> {
                selectedOptionView(answer1, 1)
            }
            R.id.answer2 -> {
                selectedOptionView(answer2, 2)
            }
            R.id.answer3 -> {
                selectedOptionView(answer3, 3)
            }
            R.id.answer4 -> {
                selectedOptionView(answer4, 4)
            }
            R.id.submit -> {
                mChooseQuestion = true;
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition += 1

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            populateQuestion()
                            mChooseQuestion = false
                        }else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answer_border)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer_border)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        submit.text = "Finish"
                    }else{
                        submit.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}
