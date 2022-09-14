package com.spora.corrutinas.db.presentation.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.spora.corrutinas.R
import com.spora.corrutinas.databinding.ItemDbBinding
import com.spora.corrutinas.db.data.Contact

class DbAdapter(private val listener: (Contact, isDelete: Boolean)->Unit): ListAdapter<Contact, DbAdapter.ViewHolder >(DiffUtilCallback) {

    class ViewHolder(private val binding: ItemDbBinding, private val listener: (Contact, isDelete: Boolean) -> Unit): RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(contact: Contact) = with(binding){
            this.contact = contact
            card.background.setTint(root.context.getColor(if(contact.isMale) R.color.isMale else R.color.isFemale))
            btnDbDelete.setOnClickListener { listener(contact, true) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemDbBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        listener
    )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item, false) }
    }
}

private object DiffUtilCallback: DiffUtil.ItemCallback<Contact>(){
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean = oldItem == newItem
}
