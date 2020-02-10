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
        return promotionsModel!!.size + 20
    }

    override fun onBindViewHolder(holder: ViewHolderRecycler, position: Int) {
<<<<<<< Updated upstream
        holder.imagePromotion.setImageResource(promotionsModel!![position].picturePromotion)
        holder.textPromotion.text = promotionsModel!![position].textPromotion

    }


    inner class ViewHolderRecycler(var item:View): RecyclerView.ViewHolder(item){
        var imagePromotion:ImageView = item.findViewById(R.id.image_promotion)
        var textPromotion:TextView = item.findViewById(R.id.text_promotion)
=======
        if (promotionsModel!!.size > 2){
            Glide.with(View(context))
                .load(promotionsModel!![1].picturePromotion)
                .centerCrop()
                .into(holder.imagePromotion)
            holder.textPromotion.text = promotionsModel!![1].textDescriptionPromotion
            holder.textCompanyName.text = promotionsModel!![1].textNameCompany
        }
        else{
            Glide.with(View(context))
                .load(promotionsModel!![position].picturePromotion)
                .centerCrop()
                .into(holder.imagePromotion)
            holder.textPromotion.text = promotionsModel!![position].textDescriptionPromotion
            holder.textCompanyName.text = promotionsModel!![position].textNameCompany
        }

    }

    inner class ViewHolderRecycler( item:View): RecyclerView.ViewHolder(item) {
        var imagePromotion: ImageView = item.findViewById(R.id.image_promotion)
        var textPromotion: TextView = item.findViewById(R.id.text_promotion)
        var textCompanyName: TextView = item.findViewById(R.id.text_company_name)
>>>>>>> Stashed changes
    }
}