package com.example.promomodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var model: List<Model>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        model = listOf(
            Model(R.drawable.ic_005_dracula,"Terror"),
            Model(R.drawable.ic_010_candy,"Infantiles"),
            Model(R.drawable.ic_019_brain,"Zombies"),
            Model(R.drawable.ic_022_ghost,"Fantasmas")
        )

        var adapter = Adapter(model, this)
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

        })
    }
}
