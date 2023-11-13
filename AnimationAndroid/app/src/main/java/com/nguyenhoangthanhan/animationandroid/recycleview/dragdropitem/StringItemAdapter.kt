package com.nguyenhoangthanhan.animationandroid.recycleview.dragdropitem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nguyenhoangthanhan.animationandroid.databinding.StringItemBinding

class StringItemAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<StringItemAdapter.StringItemViewHolder>() {

    inner class StringItemViewHolder(private val binding: StringItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.tvContent.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringItemViewHolder {
        val binding = StringItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StringItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: StringItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}