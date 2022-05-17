package com.anil.kisannetworkdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.anil.kisannetworkdemo.databinding.ContactDetailsRowBinding
import com.anil.kisannetworkdemo.models.MessageEntity

class ContactDetailsAdapter(val context: Context, val contactDetailsList: List<MessageEntity>)  : RecyclerView.Adapter<ContactDetailsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val uName = contactDetailsList[position].fName + contactDetailsList[position].lName
        val lMessage = contactDetailsList[position].message
        val lTime = contactDetailsList[position].sendTime

        if (lMessage != null) {
            if (lTime != null) {
                holder.bind(uName,lMessage,lTime)
            }
        }

    }

    override fun getItemCount(): Int {
        return contactDetailsList.size
    }

    class MyViewHolder(private val binding: ContactDetailsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(uName: String, lMessage: String, lTime: String){
            binding.txtName.text = uName
            binding.txtMessage.text = lMessage
            binding.txtTime.text = lTime
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactDetailsRowBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

}