package com.example.self_care.feature.test.viewmodel

import androidx.lifecycle.*
import com.example.self_care.domain.test.Question
import com.github.core.common.contant.QuestionsData
import com.github.core.common.contant.Score

class TestViewModel: ViewModel() {
    private val state: State = State()

    private val _questionLiveData = MutableLiveData<Any>()
    val questionLiveData: LiveData<List<Question>> = Transformations.switchMap(_questionLiveData) {
        liveData<List<Question>> {
            val question = mutableListOf<Question>()
            QuestionsData.questions.forEachIndexed { index, s ->
                val data = Question(
                    id = index,
                    question = s
                )
                question.add(data)
            }
            emit(question)
        }
    }

    private val _viewEvent = MutableLiveData<TestViewEvent>()
    val viewEvent: LiveData<TestViewEvent> get() = _viewEvent

    init {
        _questionLiveData.value = Any()
    }

    fun processEvent(e: TestViewEvent) {
        when (e) {
            TestViewEvent.OnSubmitTest -> {
                // calculate final answer
            }
            is TestViewEvent.OnAnswerTest -> {

            }
        }
    }

    data class State(
        var progress: Int = 0,
        var score: Score = Score.TIDAK_ADA
    )
}

sealed class TestViewEvent {
    object OnSubmitTest : TestViewEvent()
    data class OnAnswerTest(val Score: Score) : TestViewEvent()
}