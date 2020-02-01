package com.example.promomodule

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.promomodule.databinding.ActivityHomeBinding
import com.example.promomodule.databinding.FragmentPromoHomeBinding

class HomeActivity : AppCompatActivity(), PromoHomeFragment.OnFragmentInteractionListener,
CategoriesFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
    }

    var binding:ActivityHomeBinding? = null
    var navController:NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        navController = findNavController(R.id.fragment)

    }
    override fun onFragmentInteraction(category:String) {
        var textSended = "pizza"
        var action = PromoHomeFragmentDirections.actionPromoHomeFragmentToCategoriesFragment(textSended)

        navController!!.navigate(action)


    }
}
