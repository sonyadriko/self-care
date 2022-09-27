package com.example.self_care.feature.test.view

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.self_care.R
import com.example.self_care.databinding.ActivityPreTestBinding
import com.example.self_care.domain.QuestionData
import com.example.self_care.feature.test.viewmodel.TestViewEffect
import com.example.self_care.feature.test.viewmodel.TestViewEvent
import com.example.self_care.feature.test.viewmodel.TestViewModel
import com.github.core.common.contant.SCORE
import kotlin.math.max

class PreTestActivity : AppCompatActivity() {

    private val binding: ActivityPreTestBinding by lazy {
        ActivityPreTestBinding.inflate(layoutInflater)
    }

    private val viewModel = TestViewModel()
    private lateinit var options: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        initVariables()
        initObserver()
        initListener()
    }

    private fun initVariables() {
        options = listOf(binding.opt0, binding.opt1, binding.opt2, binding.opt3, binding.opt4)
    }

    private fun initObserver() {
        viewModel.progressLiveData.observe(this) { state ->
            if (state.isLast) binding.submit.text = getString(R.string.finish)

            binding.questionText.text = viewModel.question[state.progress].question
            binding.progressBar.apply {
                progress = state.progress+1
                max = viewModel.question.size
            }
        }

        viewModel.viewEffect.observe(this) { effect ->
            when (effect) {
                is TestViewEffect.nextActivityEffect -> {
//                    var intent= Intent(this,ResultActivity::class.java)
////                        intent.putExtra(setData.name,Name.toString())
//                    intent.putExtra(SCORE, score.toString())
//                    intent.putExtra("total size",questionList!!.size.toString())
//
//                    startActivity(intent)
//                    finish()
                }
            }
        }
    }

    private fun initListener() {
        options.forEachIndexed {index, view ->
            view.setOnClickListener {
                viewModel.setSelectedScore(index)
                setColor(view)
            }
        }

        binding.submit.setOnClickListener {
            viewModel.processEvent(TestViewEvent.OnAnswerTest)
        }
    }

    private fun setColor(opt:TextView){
        opt.background=ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        opt.typeface= Typeface.DEFAULT_BOLD
        opt.setTextColor(Color.parseColor("#000000"))

        // unset color
        options.forEach { i ->
            if (i != opt) {
                i.setTextColor(Color.parseColor("#555151"))
                i.background=ContextCompat.getDrawable(this, R.drawable.question_option)
                i.typeface= Typeface.DEFAULT
            }
        }
    }
}