package com.example.self_care.feature.test.viewmodel

import androidx.lifecycle.*
import com.example.self_care.domain.QuestionData
import com.example.self_care.domain.test.Question
import com.github.core.common.contant.QuestionsData

class TestViewModel: ViewModel() {
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
}