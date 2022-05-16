package com.anil.kisannetworkdemo.bindingAdapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.anil.kisannetworkdemo.fragments.ContactFrDirections
import com.anil.kisannetworkdemo.models.ContactModel
import com.anil.kisannetworkdemo.models.ContactResponse
import java.lang.Exception

class ContactBindings {
    companion object {

        @BindingAdapter("onRecipeClickListener")
        @JvmStatic
        fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: ContactResponse) {
            Log.d("onRecipeClickListener", "CALLED")
            recipeRowLayout.setOnClickListener {
                try {
                    val action = ContactFrDirections.actionContactFrToMessageActivity(result.results.toString())
                    recipeRowLayout.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }

    }
}