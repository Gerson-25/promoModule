package com.example.promomodule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.R
import com.example.promomodule.models.CategoriesModel
import com.example.promomodule.models.CategoryList

class CategoriesAdapter(var context:Context? = null,
                        var categoriesModel: List<CategoriesModel>? = null, var onCategoryClickListener: OnCategoryClickListener? = null): RecyclerView.Adapter<CategoriesAdapter.ViewHolderRecycler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRecycler {
        val inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.item_recycler_view_categories, parent, false)
        return ViewHolderRecycler(view, onCategoryClickListener!!)
    }

    override fun getItemCount(): Int {
        return categoriesModel!!.size
    }

    override fun onBindViewHolder(holder: ViewHolderRecycler, position: Int) {
        holder.imageMovieCategory.setImageResource(categoriesModel!![position].pictureCategory)
        holder.titleMovieCategory.text = categoriesModel!![position].nameCategory
        holder.bindData(categoriesModel!![position].nameCategory, categoriesModel!![position].pictureCategory)
    }


    inner class ViewHolderRecycler(item:View, onCategoryClickListener: OnCategoryClickListener? = null): RecyclerView.ViewHolder(item){
        var imageMovieCategory:ImageView = item.findViewById(R.id.image_category)
        var titleMovieCategory:TextView = item.findViewById(R.id.text_category)
        var itemContainer:LinearLayout= item.findViewById(R.id.item_view_pager_container)

        fun bindData(nameCategory:String, icon:Int){

            itemContainer.setOnClickListener{
                onCategoryClickListener!!.onCategoryClick(nameCategory, icon)

            }
        }



    }

    interface OnCategoryClickListener
    {
        fun onCategoryClick(categoryName: String, icon:Int)
    }

}

