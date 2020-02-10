package com.example.promomodule.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.R

import com.example.promomodule.databinding.ItemCategoriesFragmentBinding
import com.example.promomodule.models.Category
import com.example.promomodule.models.Establishment
import kotlinx.android.synthetic.main.fragment_categories.view.*
import kotlinx.android.synthetic.main.item_categories_fragment.view.*

class CategoriesFragmentAdapter():
    androidx.recyclerview.widget.ListAdapter<Establishment, EstablishmentViewHolder>(EstablishmentDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding: ItemCategoriesFragmentBinding
        binding = ItemCategoriesFragmentBinding.inflate(inflater, parent, false)

        return EstablishmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EstablishmentViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class EstablishmentDiffCallback:DiffUtil.ItemCallback<Establishment>() {
        override fun areItemsTheSame(oldItem: Establishment, newItem: Establishment): Boolean {
            return oldItem.establishment === newItem.establishment
        }
            @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Establishment, newItem: Establishment): Boolean {
            return oldItem == newItem
        }

    }

}