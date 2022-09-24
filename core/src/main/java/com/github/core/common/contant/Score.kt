package com.github.core.common.contant

enum class Score(val score: Int, val description: String) {
    TIDAK_ADA(0, "tidak ada kecemasan"),
    RINGAN(1, "kecemasan ringan"),
    SEDANG(2, "kecemasan sedang"),
    BERAT(3, "kecemasan berat"),
    BERAT_SEKALI(4, "kecemasan berat sekali")
}