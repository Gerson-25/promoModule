package com.example.promomodule.models

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.Timestamp
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    var category_id: String? = ""
) : Parcelable


@Parcelize
data class Establishment(
    var description: String? = "",
    var direction: String? = "",
    var phone_number: String? = "",
    var establishment: String? = "",
    var establishment_id:String=""


) : Parcelable

@Parcelize
data class Promotion(
    //var date:String?="",
    var date: Timestamp?= Timestamp.now(),
    var description: String? = "",
    var promotion_id: String? = "",
    var image: String? = "",
    var likes: Int? = 0,
    var promotion_name: String? = "",
    var rating: Double? = 0.0,
    var establishment_id: String?="",
    var establishment:String?=""


) : Parcelable