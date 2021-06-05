package com.s95ammar.fragmentdemo.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Product(
    val name: String,
    val price: Int
) : Parcelable
