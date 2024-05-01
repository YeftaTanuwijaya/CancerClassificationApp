package com.dicoding.asclepius.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.data.local.History
import com.dicoding.asclepius.databinding.ItemRowHistoryBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val list = ArrayList<History>()

    fun setList(histories: ArrayList<History>) {
        list.clear()
        list.addAll(histories)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(val binding: ItemRowHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.apply {
                ivCancer.setImageURI(history.image)
                tvResult.text = history.result
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.HistoryViewHolder {
        val view = ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder((view))
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}