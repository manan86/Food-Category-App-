package com.codegalaxy.mealapidaggerwitheverything12_03.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.codegalaxy.mealapidaggerwitheverything12_03.databinding.ItemViewBinding
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodResponse
import javax.inject.Inject

class FoodAdapter @Inject constructor(private val list : List<FoodResponse>) : RecyclerView.Adapter<FoodAdapter.viewHolder>() {

    inner class viewHolder(val binding : ItemViewBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater,parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val foodList = list[position]
        with(holder.binding){
            Glide.with(holder.itemView.context)
                .load(foodList.image)
                .into(imageView)

            tvFoodId.text = foodList.id
            tvCategory.text = foodList.category
            tvDesc.text = foodList.desc
        }
    }
}