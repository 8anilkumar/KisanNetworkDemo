package com.anil.kisannetworkdemo.models

import com.google.gson.annotations.SerializedName

data class ContactModel (
    @SerializedName("fName")
    val fName: String,
    @SerializedName("lName")
    val lName: String,
    @SerializedName("number")
    val number: String
   )

