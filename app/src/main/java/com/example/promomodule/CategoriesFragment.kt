package com.example.promomodule

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.promomodule.adapters.CategoriesFragmentAdapter
import com.example.promomodule.databinding.FragmentCategoriesBinding
import com.example.promomodule.models.CompaniesModel
import com.example.promomodule.viewModel.AllianceViewModel
import kotlinx.android.synthetic.main.fragment_categories.view.*


private const val ARG_PARAM1 = "nameCategory"
private const val ARG_PARAM2 = "icon"
private const val ARG_PARAM3 = "position"


class CategoriesFragment : Fragment() {

    private var param1: String? = null
    private var param2: Int? = null
    private var param3: Int? = null
    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentCategoriesBinding? = null
    private val viewModel by lazy { ViewModelProviders.of(this).get(AllianceViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_categories, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.text_name_category.text = param1
        view.icon_category.setImageResource(param2!!)

        Toast.makeText(context,"value:$param3 ", Toast.LENGTH_SHORT).show()

        binding!!.lifecycleOwner

        viewModel.getCategories()
        viewModel.establishment.observe(viewLifecycleOwner, Observer {
        })
        var categoryListSize = viewModel.categories.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "value: ${it.size}", Toast.LENGTH_SHORT).show()

            var adapter = CategoriesFragmentAdapter(context, it)
            binding!!.categoriesRecyclerViewFragment.adapter =adapter
            binding!!.categoriesRecyclerViewFragment.layoutManager= LinearLayoutManager(context)
        })

    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance(param1: String, param2: Int, param3: Int) =
            CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                    putInt(ARG_PARAM3, param3)
                }
            }
    }
}
