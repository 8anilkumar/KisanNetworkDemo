package com.anil.kisannetworkdemo.utils

import androidx.room.TypeConverter
import com.anil.kisannetworkdemo.models.ContactModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MessageTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun numberRecipeToString(foodRecipe: ContactModel): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodNumber(data: String): ContactModel {
        val listType = object : TypeToken<ContactModel>() {}.type
        return gson.fromJson(data, listType)
    }
}