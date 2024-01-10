package com.example.applemarket

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class myItem(val aIcon: String,
                  val aProductName: String,
                  val aDescription: String,
                  val aUsername: String,
                  val aPrice: Int,
                  val aAddress: String,
                  val aLikes: Int,
                  val aCommentNum: Int
): Parcelable