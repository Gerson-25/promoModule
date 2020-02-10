package com.example.promomodule.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.databinding.ItemCategoriesFragmentBinding
import com.example.promomodule.models.Establishment

class EstablishmentViewHolder(val binding: ItemCategoriesFragmentBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Establishment){
            binding.establishment = item
            binding.executePendingBindings()
    }

}
