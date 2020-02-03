package com.example.promomodule

import android.net.Uri
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.promomodule.adapters.CategoriesAdapter
import com.example.promomodule.databinding.ActivityHomeBinding
import com.example.promomodule.databinding.FragmentPromoHomeBinding

class HomeActivity : AppCompatActivity(), PromoHomeFragment.OnFragmentInteractionListener,
CategoriesFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
    }

    var binding:ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

    }
    override fun onFragmentInteraction(category:String) {
    }


}
