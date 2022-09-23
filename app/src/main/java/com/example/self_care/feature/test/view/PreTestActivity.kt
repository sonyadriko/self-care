package com.example.self_care.feature.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.self_care.databinding.ActivityPreTestBinding
import com.example.self_care.feature.test.viewmodel.TestViewModel

class PreTestActivity : AppCompatActivity() {

    private val binding: ActivityPreTestBinding by lazy {
        ActivityPreTestBinding.inflate(layoutInflater)
    }

    private val viewModel = TestViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        initObserver()
    }

    private fun initObserver() {
        viewModel.questionLiveData.observe(this) {

        }
    }
}