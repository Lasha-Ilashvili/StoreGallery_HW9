package com.example.storegallery_hw9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storegallery_hw9.databinding.FilterItemRecyclerviewBinding

class FilterRecyclerAdapter(
    private val filters: MutableList<Filter>,
    private val onFilterClickListener: (Filter) -> Unit
) :
    RecyclerView.Adapter<FilterRecyclerAdapter.FilterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(
            FilterItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return filters.size
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind()
        holder.itemView.setOnClickListener { onFilterClickListener(filters[position]) }
    }

    inner class FilterViewHolder(private val binding: FilterItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val filter = filters[adapterPosition]
            with(binding) {
                tvFilterEmoji.text = filter.filterEmoji
                tvFilterType.text = filter.filterType
            }
        }
    }
}