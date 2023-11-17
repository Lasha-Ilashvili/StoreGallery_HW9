package com.example.storegallery_hw9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storegallery_hw9.databinding.StoreItemRecyclerviewBinding

class StoreItemRecyclerAdapter(private val storeItems: MutableList<StoreItem>) :
    RecyclerView.Adapter<StoreItemRecyclerAdapter.StoreItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            StoreItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return storeItems.size
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        holder.bind()
    }

    fun updateItems(newItems: List<StoreItem>) {
        storeItems.clear()
        storeItems.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class StoreItemViewHolder(private val binding: StoreItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val storeItem = storeItems[adapterPosition]
            with(binding) {
                storeItemModel.setImageResource(storeItem.itemModel)
                storeItemTitle.text = storeItem.itemTitle
                storeItemPrice.text = storeItem.itemPrice
            }
        }
    }
}
