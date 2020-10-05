package com.balsa.coolquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    var mUserName:String? = null
    var mTotalQuestions:String? = null
    var mCorrectAnswers:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mTotalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0).toString()
        mCorrectAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0).toString()

        playerName_tf.text = mUserName
        score_tf.text = "Your score is " + mCorrectAnswers + "/" + mTotalQuestions

        playAgain_btn.setOnClickListener{
            startActivity(Intent(this, QuizQuestionsActivity::class.java))
            finish()
        }

    }
}
