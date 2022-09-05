package com.spora.corrutinas.main.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.spora.corrutinas.databinding.ItemLayoutBinding

class MainAdapter: ListAdapter<String, MainAdapter.ViewHolder >(DiffUtilCallback) {

    class ViewHolder(view: ItemLayoutBinding): RecyclerView.ViewHolder(view.root){
        val tv: TextView
        init { tv = view.tv }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.tv.text = getItem(position) }
}

private object DiffUtilCallback: DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}
