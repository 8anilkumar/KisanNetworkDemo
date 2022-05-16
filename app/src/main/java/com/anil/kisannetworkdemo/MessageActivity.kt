package com.anil.kisannetworkdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MessageActivity : AppCompatActivity() {

    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

       if(intent.extras != null){
           userName = intent?.extras?.getString("fname")

           Toast.makeText(applicationContext,""+userName,Toast.LENGTH_SHORT).show()
       }
    }
}