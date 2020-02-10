package com.example.promomodule.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promomodule.models.Establishment
import com.google.firebase.firestore.FirebaseFirestore

class EstablishmentsViewModel : ViewModel() {

    private var db= FirebaseFirestore.getInstance()

    private var _establishments = MutableLiveData<MutableList<Establishment>>()

    val establishment: LiveData<MutableList<Establishment>>
        get() = _establishments

    fun getFireStoreEstablishments(category:String){

        // var allEstablishment= mutableListOf<EstablishmentFS>()

        db.collection("alliance").document(category).collection("establishments").get()
            .addOnSuccessListener {snap->

                val obj=snap.toObjects(Establishment::class.java)

                _establishments.value=obj
                Log.d("testing2","the object is ->$obj")



            }


    }
}