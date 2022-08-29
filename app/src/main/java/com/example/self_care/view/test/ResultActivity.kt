package com.example.self_care.view.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.self_care.MainActivity
import com.example.self_care.R
import com.example.self_care.domain.QuestionData
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
//        val userName=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(QuestionData.score)
        val totalQuestion=intent.getStringExtra("total size")

//        congo.text="Congratulations ${userName} !!"
        Score.text="${score} / ${totalQuestion}"
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}