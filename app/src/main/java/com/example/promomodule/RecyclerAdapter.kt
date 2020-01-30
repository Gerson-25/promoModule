package com.example.promomodule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var context:Context? = null,
                      var model: List<Model>? = null): RecyclerView.Adapter<RecyclerAdapter.ViewHolderRecycler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRecycler {
        val inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.swipe_pager_item_categories, parent, false)

        return ViewHolderRecycler(view)
    }

    override fun getItemCount(): Int {
       return model!!.size
    }

    override fun onBindViewHolder(holder: ViewHolderRecycler, position: Int) {

        holder.imageMovieCategory.setImageResource(model!![position].pictureCategory)
        holder.titleMovieCategory.text =model!![position].nameCategory

    }


    inner class ViewHolderRecycler(var item:View): RecyclerView.ViewHolder(item){
        var imageMovieCategory:ImageView = item.findViewById(R.id.image_category)
        var titleMovieCategory:TextView = item.findViewById(R.id.text_category)
    }
}

