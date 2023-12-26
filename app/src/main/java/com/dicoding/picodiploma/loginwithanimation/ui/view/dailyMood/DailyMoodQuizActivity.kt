package com.dicoding.picodiploma.loginwithanimation.ui.view.dailyMood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.data.DailyMoodQuestionData
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityDailyMoodQuizBinding

class DailyMoodQuizActivity : AppCompatActivity() {
    private lateinit var adapter: QuizAdapter
    private lateinit var recyclerView: RecyclerView
//    private lateinit var recyclerView: ListView
    private lateinit var binding: ActivityDailyMoodQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyMoodQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_daily_mood_quiz)

        recyclerView = findViewById(R.id.rvKuis)
        recyclerView.setHasFixedSize(true)

//         Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        setQuestion()
    }

    fun setQuestion(){
//        val ListKarakterAdapter = QuizAdapter(DailyMoodQuestionData.questions)
        adapter = QuizAdapter(
            DailyMoodQuestionData.questions,
            { question, answer ->
                // Do something with the answer
            }
        )
        recyclerView.adapter = adapter
    }
}