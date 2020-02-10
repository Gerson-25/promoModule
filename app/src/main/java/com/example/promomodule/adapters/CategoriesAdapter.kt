package com.example.promomodule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.R
import com.example.promomodule.models.CategoriesModel

class CategoriesAdapter(var context:Context? = null,
                        var categoriesModel: List<CategoriesModel>? = null): RecyclerView.Adapter<CategoriesAdapter.ViewHolderRecycler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRecycler {
        val inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.item_recycler_view_categories, parent, false)

        return ViewHolderRecycler(view)
    }

    override fun getItemCount(): Int {
       return categoriesModel!!.size
    }

    override fun onBindViewHolder(holder: ViewHolderRecycler, position: Int) {
<<<<<<< Updated upstream

        holder.imageMovieCategory.setImageResource(categoriesModel!![position].pictureCategory)
        holder.titleMovieCategory.text =categoriesModel!![position].nameCategory

=======
        holder.imageMovieCategory.setImageResource(iconsList!![position].pictureCategory)
        holder.titleMovieCategory.text = categoryList!![position].category_id
        holder.bindData(categoryList!![position].category_id!!, iconsList!![position].pictureCategory, position)
>>>>>>> Stashed changes
    }


    inner class ViewHolderRecycler(var item:View): RecyclerView.ViewHolder(item){
        var imageMovieCategory:ImageView = item.findViewById(R.id.image_category)
        var titleMovieCategory:TextView = item.findViewById(R.id.text_category)
    }
}

