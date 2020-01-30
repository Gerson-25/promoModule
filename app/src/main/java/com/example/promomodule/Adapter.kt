package com.example.promomodule

import android.content.Context
import android.graphics.ColorSpace
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class Adapter(var model:List<Model>? = null, var context:Context? = null): PagerAdapter() {

    var inflater: LayoutInflater? = null
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun getCount(): Int {
        return model!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //return super.instantiateItem(container, position)
        inflater = LayoutInflater.from(context)
        var view= inflater!!.inflate(R.layout.swipe_pager_item_categories, container, false)

        var imageCategory:ImageView
        var nameCategory:TextView

        imageCategory = view.findViewById(R.id.image_category)
        nameCategory = view.findViewById(R.id.text_category)

        imageCategory.setImageResource(model!![position].pictureCategory)
        nameCategory.text = model!![position].nameCategory

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)

        container.removeView(View(context))
    }
}