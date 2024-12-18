package com.example.apistart.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apistart.data.model.DrinkModel
import com.example.apistart.databinding.ItemUserBinding

class DisplayAdapter(
private val userList: List<DrinkModel?>  // Change this to ResultModel
) : RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder>() {

    inner class DisplayViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Bind data to the views in the layout
        fun bind(response: DrinkModel?) {  // Change this to ResultModel
            binding.apply {
                // Set user's name
                tvName.text = "Name: ${response?.strCategory}" +
                        " ${response?.strDrink}"

                // Set user's email
                tvEmail.text = response?.strAlcoholic

                // Load user's profile picture using Glide
                Glide.with(ivProfile.context)
                    .load(response?.strDrinkThumb)
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