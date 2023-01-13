package com.example.self_care.feature.test.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.example.self_care.domain.test.Question
import com.example.self_care.domain.test.Result
import com.github.core.common.contant.QuestionsData
import com.github.core.common.contant.SCORE_INT_EXTRA
import java.lang.Exception

class TestViewModel: ViewModel() {
    private val _question = mutableListOf<Question>()
    val question : List<Question> get() = _question

    private val _progressLiveData = MutableLiveData<State>()
    val progressLiveData: LiveData<State> get() = _progressLiveData

    private var selectedScore: Int = 0

    private val _viewEffect = MutableLiveData<TestViewEffect>()
    val viewEffect: LiveData<TestViewEffect> get() = _viewEffect

    init {
        QuestionsData.questions.forEachIndexed { index, s ->
            val data = Question(
                id = index,
                question = s
            )
            _question.add(data)
        }.also {
            _progressLiveData.value = State(progress = 1)
        }
    }

    fun setSelectedScore(score: Int) {
        selectedScore = score
    }

    fun processEvent(event: TestViewEvent) {
        try {
            val state = _progressLiveData.value!!
            when (event) {
                TestViewEvent.OnSubmitTest -> {
                    QuestionsData.calculateTotalScore(state.currentScore)
                }
                is TestViewEvent.OnAnswerTest -> {
                    if (state.isLast) {
                        val result = Result(
                            totalScore = _progressLiveData.value!!.currentScore,
                            message = QuestionsData.calculateTotalScore(
                                _progressLiveData.value!!.currentScore
                            ).description
                        )

                        _viewEffect.value = TestViewEffect.NextActivityEffect(bundle = Bundle().apply {
                            putParcelable(SCORE_INT_EXTRA, result)
                        })
                        return
                    }

                    val progress = state.progress+1
                    _progressLiveData.value = state.copy(
                        progress = progress,
                        currentScore = state.currentScore+selectedScore,
                        isLast = progress == question.size-1
                    )
                }
            }
        } catch (e: Exception) {
            _viewEffect.value = TestViewEffect.ToastEffect()
        }
    }

    data class State(
        val progress: Int = 0,
        val currentScore: Int = 0,
        val isLast: Boolean = false,
    )
}

sealed class TestViewEvent {
    object OnSubmitTest : TestViewEvent()
    object OnAnswerTest : TestViewEvent()
}

sealed class TestViewEffect {
    data class NextActivityEffect(val bundle: Bundle? = null): TestViewEffect()
    data class ToastEffect(val message: String = "Something Wrong"): TestViewEffect()
}