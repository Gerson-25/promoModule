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
            CategoriesModel(R.drawable.ic_mortarboard),
            CategoriesModel(R.drawable.ic_pizza),
            CategoriesModel(R.drawable.ic_shopping_cart),
            CategoriesModel(R.drawable.ic_stethoscope),
            CategoriesModel(R.drawable.ic_ticket)
        )
        promotionsModel = listOf(
            PromotionsModel("https://www.america-retail.com/static//2018/10/Pizza-Hut.jpg", resources.getString(R.string.text_lorem_ipsum),"Pizza Hut"),
            PromotionsModel("https://fastly.4sqi.net/img/general/699x268/54779162_VogiIWp98J66Fa3ngwwuMkIRa3b-LRGWrRYa6x0fby4.jpg", resources.getString(R.string.text_lorem_ipsum), "Almacenes Siman"),
            PromotionsModel("https://www.mercadofitness.com/wp-content/uploads/2014/07/Be-Fit-inaugur%C3%B3-su-tercer-gimnasio-en-El-Salvador-.jpg", resources.getString(R.string.text_lorem_ipsum), "Be Fit")
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
        /*categoriesRecycler = findViewById(R.id.categories_recycler_view)
        var setCategoryAdapter = CategoriesAdapter(this,  ,categoriesModel)
        categoriesRecycler!!.adapter = setCategoryAdapter
        categoriesRecycler!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/
    }
}
