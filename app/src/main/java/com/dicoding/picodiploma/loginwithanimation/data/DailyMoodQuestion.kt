package com.dicoding.picodiploma.loginwithanimation.data

data class DailyMoodQuestion(
    var id: Int,
    var radioId: Int,
    var pertanyaan: String,
    var bobotSetuju: Int,
    var boboSangatSetuju: Int,
    var bobotTidakSeuju: Int,
    var bobotSangatTidakSeuju: Int
)