package com.dicoding.picodiploma.loginwithanimation.ui.view.dailyMood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.data.DailyMoodQuestion

class QuizAdapter(
    private val questions: List<DailyMoodQuestion>,
    private val onAnswerSelected: (DailyMoodQuestion, Int) -> Unit
) : RecyclerView.Adapter<QuizAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(
//            R.layout.item_quiz_daily,
//            parent,
//            false
//        )
//        return ViewHolder(view)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_quiz_daily, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val question = questions[position]

        holder.questionTextView.text = question.pertanyaan

//        for (i in 0 until holder.radioGroup.childCount) {
//            val radioButton = holder.radioGroup.getChildAt(i) as RadioButton
////            radioButton.text = question.answers[i]
//
////            if (question.answer == i) {
//                radioButton.isChecked = true
////            }
//        }

        holder.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            onAnswerSelected(question, checkedId)
        }
    }

    override fun getItemCount(): Int = questions.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.question)
        val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
    }
}