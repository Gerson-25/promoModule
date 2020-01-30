package com.example.promomodule

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var model: List<Model>? = null
    var recyclerView:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        model = listOf(
            Model(R.drawable.ic_mortarboard,"Educación"),
            Model(R.drawable.ic_pizza,"Restaurante"),
            Model(R.drawable.ic_shopping_cart,"Mercado"),
            Model(R.drawable.ic_stethoscope,"Salud"),
            Model(R.drawable.ic_ticket,"Cine"))

        var adapter = Adapter(model, this)
        viewPager!!.adapter  = adapter
        viewPager!!.setPadding(0, 0 ,0, 0)
        recyclerView = findViewById(R.id.recyclerView)

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

        })

        var setAdapter = RecyclerAdapter(this,model)

        recyclerView!!.adapter = setAdapter

        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
