package com.example.apistart.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apistart.data.api.model.ResultModel
import com.example.apistart.databinding.ItemUserBinding

class DisplayAdapter(
private val userList: List<ResultModel?>  // Change this to ResultModel
) : RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder>() {

    inner class DisplayViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Bind data to the views in the layout
        fun bind(response: ResultModel?) {  // Change this to ResultModel
            binding.apply {
                // Set user's name
                tvName.text = "${response?.name?.first}" +
                        " ${response?.name?.last}"

                // Set user's email
                tvEmail.text = response?.email

                // Load user's profile picture using Glide
                Glide.with(ivProfile.context)
                    .load(response?.picture?.large)
                    .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                    .error(android.R.drawable.stat_notify_error)
                    .into(ivProfile)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DisplayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DisplayViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = userList.size
}