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
import com.example.promomodule.models.PromotionsModel

class PromotionsAdapter(var context:Context? = null,
                      var promotionsModel: List<PromotionsModel>? = null): RecyclerView.Adapter<PromotionsAdapter.ViewHolderRecycler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRecycler {
        val inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.item_recycler_view_promotion, parent, false)

        return ViewHolderRecycler(view)
    }

    override fun getItemCount(): Int {
        return promotionsModel!!.size
    }

    override fun onBindViewHolder(holder: ViewHolderRecycler, position: Int) {
        holder.imagePromotion.setImageResource(promotionsModel!![position].picturePromotion)
        holder.textPromotion.text = promotionsModel!![position].textPromotion

    }


    inner class ViewHolderRecycler(var item:View): RecyclerView.ViewHolder(item){
        var imagePromotion:ImageView = item.findViewById(R.id.image_promotion)
        var textPromotion:TextView = item.findViewById(R.id.text_promotion)
    }
}