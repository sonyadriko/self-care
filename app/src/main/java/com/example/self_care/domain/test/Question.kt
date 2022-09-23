package com.example.self_care.domain.test

import com.github.core.common.contant.Score

data class Question (
    val id: Int,
    val question: String,
    val answer: Score = Score.TIDAK_ADA
)