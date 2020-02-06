package com.example.promomodule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.R
import com.example.promomodule.models.Category
import com.example.promomodule.models.Establishment
import kotlinx.android.synthetic.main.fragment_categories.view.*
import kotlinx.android.synthetic.main.item_categories_fragment.view.*

class CategoriesFragmentAdapter(var context:Context? = null, var categoryLsit: MutableList<Category>? = null): RecyclerView.Adapter<CategoriesFragmentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.item_categories_fragment, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return categoryLsit!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name_txt.text = categoryLsit!![position].establishments!!.establishment!!
    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {
        var name_txt = item.text_company_name

        fun bindData(){

        }

    }
}