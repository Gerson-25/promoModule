package com.example.promomodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.promomodule.adapters.CategoriesAdapter
import com.example.promomodule.adapters.PromotionsAdapter
import com.example.promomodule.models.CategoriesModel
import com.example.promomodule.models.PromotionsModel

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var categoriesModel: List<CategoriesModel>? = null
    var promotionsModel: List<PromotionsModel>? = null
    var categoriesRecycler:RecyclerView? = null
    var promotionsRecycler:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewPager = findViewById(R.id.viewPager)

        categoriesModel = listOf(
            CategoriesModel(R.drawable.ic_mortarboard, "Educación"),
            CategoriesModel(R.drawable.ic_pizza, "Restaurante"),
            CategoriesModel(R.drawable.ic_shopping_cart, "Mercado"),
            CategoriesModel(R.drawable.ic_stethoscope, "Salud"),
            CategoriesModel(R.drawable.ic_ticket, "Cine")
        )
        promotionsModel = listOf(
            PromotionsModel(R.drawable.ic_mortarboard, (R.string.text_lorem_ipsum).toString()),
            PromotionsModel(R.drawable.ic_pizza, (R.string.text_lorem_ipsum).toString()),
            PromotionsModel(R.drawable.ic_pizza, (R.string.text_lorem_ipsum).toString())
        )

        /*
        SETTING VIEW PAGER DATA
        var adapter = ViewPagerAdapter(categoriesModel, this)
        viewPager!!.adapter  = adapter
        viewPager!!.setPadding(0, 0 ,0, 0)


        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

        })*/
        //SETTING PROMOTION_RECYCLERVIEW
        promotionsRecycler = findViewById(R.id.promotions_recycler_view)

        var setPromotionAdapter = PromotionsAdapter(this, promotionsModel)

        promotionsRecycler!!.adapter = setPromotionAdapter

        promotionsRecycler!!.layoutManager = LinearLayoutManager(this)


        //SETTING CATEGORIES_RECYCLERVIEW
        categoriesRecycler = findViewById(R.id.categories_recycler_view)

        var setCategoryAdapter = CategoriesAdapter(this, categoriesModel)

        categoriesRecycler!!.adapter = setCategoryAdapter

        categoriesRecycler!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}
