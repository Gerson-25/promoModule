package com.example.promomodule

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.promomodule.adapters.CategoriesAdapter
import com.example.promomodule.adapters.PromotionsAdapter
import com.example.promomodule.databinding.FragmentPromoHomeBinding
import com.example.promomodule.models.CategoriesModel
import com.example.promomodule.models.PromotionsModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PromoHomeFragment : Fragment() {

    private var binding : FragmentPromoHomeBinding? = null
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var categoriesModel:List<CategoriesModel>? = null
    private var promotionsModel:List<PromotionsModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_promo_home,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriesModel = listOf(
            CategoriesModel(R.drawable.ic_mortarboard, "Educación"),
            CategoriesModel(R.drawable.ic_pizza, "Comida"),
            CategoriesModel(R.drawable.ic_shopping_cart, "Mercado"),
            CategoriesModel(R.drawable.ic_stethoscope, "Salud"),
            CategoriesModel(R.drawable.ic_ticket, "Cine")
        )

        promotionsModel = listOf(
            PromotionsModel("https://www.america-retail.com/static//2018/10/Pizza-Hut.jpg", resources.getString(R.string.text_lorem_ipsum),"Pizza Hut"),
            PromotionsModel("https://fastly.4sqi.net/img/general/699x268/54779162_VogiIWp98J66Fa3ngwwuMkIRa3b-LRGWrRYa6x0fby4.jpg", resources.getString(R.string.text_lorem_ipsum), "Almacenes Siman"),
            PromotionsModel("https://www.mercadofitness.com/wp-content/uploads/2014/07/Be-Fit-inaugur%C3%B3-su-tercer-gimnasio-en-El-Salvador-.jpg", resources.getString(R.string.text_lorem_ipsum), "Be Fit")
        )

        binding!!.categoriesRecyclerView
        var setCategoryAdapter = CategoriesAdapter(context, categoriesModel)
        binding!!.categoriesRecyclerView.adapter = setCategoryAdapter
        binding!!.categoriesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding!!.sendButton.setOnClickListener {
            var category = "Comida"
            listener!!.onFragmentInteraction(category)
        }

        var setPromotionAdapter = PromotionsAdapter(context, promotionsModel)

        binding!!.promotionsRecyclerView.adapter = setPromotionAdapter

        binding!!.promotionsRecyclerView.layoutManager = LinearLayoutManager(context)


    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction("Salud")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(category:String)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PromoHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}