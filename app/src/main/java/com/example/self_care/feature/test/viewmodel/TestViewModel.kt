package com.example.self_care.feature.test.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.example.self_care.domain.test.Question
import com.github.core.common.contant.QuestionsData
import com.github.core.common.contant.Score

class TestViewModel: ViewModel() {
    private val _question = mutableListOf<Question>()
    val question : List<Question> get() = _question

    private val _progressLiveData = MutableLiveData<State>()
    val progressLiveData: LiveData<State> get() = _progressLiveData

    private var selectedScore: Int = 0

    private val _viewEvent = MutableLiveData<TestViewEvent>()

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
        val state = _progressLiveData.value!!
        when (event) {
            TestViewEvent.OnSubmitTest -> {
                QuestionsData.calculateTotalScore(state.currentScore)
            }
            is TestViewEvent.OnAnswerTest -> {
                if (state.isLast) {
                    _viewEffect.value = TestViewEffect.nextActivityEffect()
                    return
                }

                val progress = state.progress+1
                _progressLiveData.value = state.copy(
                    progress = progress,
                    currentScore = state.currentScore+selectedScore,
                    isLast = progress+1 == question.size-1
                )
            }
        }
    }

    data class State(
        val progress: Int = 0,
        val currentScore: Int = 0,
        val totalScore: Score = Score.TIDAK_ADA,
        val isLast: Boolean = false,
    )
}

sealed class TestViewEvent {
    object OnSubmitTest : TestViewEvent()
    object OnAnswerTest : TestViewEvent()
}

sealed class TestViewEffect {
    data class nextActivityEffect(val bundle: Bundle? = null): TestViewEffect()
}