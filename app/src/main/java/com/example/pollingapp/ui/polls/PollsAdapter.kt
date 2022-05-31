package com.example.pollingapp.ui.polls

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pollingapp.R
import com.example.pollingapp.data.Poll
import com.example.pollingapp.data.isFull

class PollsAdapter(private val polls: List<Poll>, val onPollClick: (Int) -> Unit) :
    RecyclerView.Adapter<PollsAdapter.PollsViewHolder>() {

    class PollsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.poll_name)
        val size = itemView.findViewById<TextView>(R.id.poll_questions_size)
        val status = itemView.findViewById<TextView>(R.id.poll_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PollsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_poll_overview, parent, false)
        return PollsViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PollsViewHolder, position: Int) {
        val poll = polls[position]
        holder.name.text = poll.name
        holder.size.text = "Количество вопросов: ${poll.questions.count()}"
        holder.status.text = "Статуc: ${if (poll.isFull()) "Пройден" else "Не пройден"}"
        holder.status.setTextColor(if (poll.isFull()) Color.GRAY else Color.RED)
        holder.itemView.setOnClickListener {
            onPollClick(poll.id)
        }
    }

    override fun getItemCount() = polls.size
}