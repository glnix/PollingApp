package com.example.pollingapp.ui.polling

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pollingapp.R
import com.example.pollingapp.data.Poll

class PollingAdapter(val poll: Poll, val clickListener: (Int, Int, Boolean) -> Unit) :
    RecyclerView.Adapter<PollingAdapter.PollsViewHolder>() {

    class PollsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.question_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PollsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_question, parent, false)
        return PollsViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PollsViewHolder, position: Int) {
        val question = poll.questions[position]
        holder.title.text = question.title
        question.answers.forEach { answer ->
            val checkBox = CheckBox(holder.itemView.context)
            checkBox.text = answer.title
            checkBox.isChecked = answer.isChecked
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                clickListener(question.id, answer.id, isChecked)
            }
            (holder.itemView as LinearLayout).addView(checkBox)
        }
    }

    override fun getItemCount() = poll.questions.count()
}