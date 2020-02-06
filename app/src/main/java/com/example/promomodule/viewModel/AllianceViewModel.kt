package com.example.promomodule.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promomodule.models.Category
import com.example.promomodule.models.Establishment
import com.example.promomodule.models.Promotion
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllianceViewModel: ViewModel() {

    private var firestoredb = FirebaseDatabase.getInstance().getReference("alliance")

    private var _categories = MutableLiveData<MutableList<Category>>()
    private var _establishments = MutableLiveData<MutableList<Establishment>>()

    val categories: LiveData<MutableList<Category>>
        get() = _categories
    val establishment:LiveData<MutableList<Establishment>>
        get() = _establishments

    fun getCategories() {

        val allCategory = mutableListOf<Category>()
        val allEstablishment = mutableListOf<Establishment>()


        firestoredb.addValueEventListener( object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {

                    dataSnapshot.children.forEach { category ->

                        val cate = category.getValue(Category::class.java) as Category

                        category.children.forEach { establishment ->
                            if (establishment.key == "establishments") {

                                establishment.children.forEach { establishmentKey ->

                                        val est = establishmentKey.getValue(Establishment::class.java) as Establishment
                                        cate.establishments = est


                                    establishmentKey.children.forEach { promotions ->
                                        if (promotions.key == "promotions") {
                                            promotions.children.forEach {

                                                val promo = it.getValue(Promotion::class.java)
                                                cate.establishments?.promotions = promo

                                            }
                                        }
                                    }
                                }

                            }

                        }
                        allCategory.add(cate)
                    }


                } else {
                    Log.d("categories", "No categories")
                }

                _categories.value = allCategory
                Log.d("Categories-mutable", "${_categories.value}")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("The read failed: " + databaseError.code)
            }


        })
    }

}