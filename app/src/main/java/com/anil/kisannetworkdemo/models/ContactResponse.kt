package com.anil.kisannetworkdemo.models

import com.google.gson.annotations.SerializedName


data class ContactResponse (
    @SerializedName("users")
    val results: List<ContactModel>)