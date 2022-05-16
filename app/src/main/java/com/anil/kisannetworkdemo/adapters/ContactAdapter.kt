package com.anil.kisannetworkdemo.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.anil.kisannetworkdemo.MessageActivity
import com.anil.kisannetworkdemo.databinding.ContactRowLayoutBinding

class ContactAdapter(val context: Context,val fNameList: List<String>,val lNameList: List<String>,val number: List<String>)  : RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fNameList = fNameList[position]
        val lNameList = lNameList[position]
        val numberList = number[position]

        holder.bind(fNameList,lNameList,numberList)

        holder.dataRowLayout.setOnClickListener {
            val intent = Intent(context,MessageActivity::class.java)
            intent.putExtra("fname",fNameList)
            intent.putExtra("lname",lNameList)
            intent.putExtra("number",numberList)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return fNameList.size
    }

    class MyViewHolder(private val binding: ContactRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val dataRowLayout: LinearLayout = binding.dataRowLayout

        fun bind(fNameList: String, lNameList: String, numberList: String){
            binding.txtFname.text = "First Name: "+fNameList
            binding.txtLname.text = "Last Name: "+lNameList
            binding.txtNumber.text = "Mobile Number: "+numberList
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

}