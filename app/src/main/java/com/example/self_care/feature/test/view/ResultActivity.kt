package com.example.self_care.feature.test.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.self_care.databinding.ActivityResultBinding
import com.example.self_care.domain.test.Result
import com.github.core.common.contant.SCORE_DATA_EXTRA

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding
    private lateinit var result : Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        try {
            result = intent.getParcelableExtra(SCORE_DATA_EXTRA)!!

            binding.Result.text = result.message
            binding.Score.text = result.totalScore.toString()
        } catch (e: Exception) {
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            finish()
        }
    }
}