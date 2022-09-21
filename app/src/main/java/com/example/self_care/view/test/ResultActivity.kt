package com.example.self_care.view.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.self_care.MainActivity
import com.example.self_care.databinding.ActivityResultBinding
import com.example.self_care.domain.QuestionData
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
//        val userName=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(QuestionData.score)
        val totalQuestion=intent.getStringExtra("total size")

//        congo.text="Congratulations ${userName} !!"
        var resultxInt = score
        if (resultxInt == "1"){
            binding.Result.setText("Sangat Tidak Sehat")
        }else if(resultxInt == "2"){
            binding.Result.setText("Tidak Sehat")
        }else if(resultxInt == "3"){
            binding.Result.setText("Normal")
        }else if(resultxInt == "4"){
            binding.Result.setText("Sehat")
        }else if(resultxInt == "5"){
            binding.Result.setText("Sangat Sehat")
        }
        Score.text="${score} / ${totalQuestion}"

        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}