package com.anil.kisannetworkdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.anil.kisannetworkdemo.data.network.HistoryDatabase
import com.anil.kisannetworkdemo.databinding.ActivityMessageBinding
import com.anil.kisannetworkdemo.models.MessageEntity
import com.anil.kisannetworkdemo.utils.Constants.Companion.DATABASE_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MessageActivity : AppCompatActivity() {

    private var binding: ActivityMessageBinding? = null
    var userMobile: String? = null
    var userFname: String? = null
    var userLname: String? = null
    private lateinit var historyDatabase: HistoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpDB()

       if(intent.extras != null){
           userFname = intent?.extras?.getString("fname")
           userLname = intent?.extras?.getString("lname")
           userMobile = intent?.extras?.getString("number")
       }

        binding?.submitLayout?.setOnClickListener {
            val sdf = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
            val currentDateandTime: String = sdf.format(Date())
            val etMessage = binding?.etMessage?.text?.trim()
            val message: String = etMessage.toString()
            saveUsersData(userMobile,userFname,userLname,currentDateandTime,message)
        }
    }

    private fun setUpDB() {
        historyDatabase = Room.databaseBuilder(this@MessageActivity,HistoryDatabase::class.java,DATABASE_NAME)
            .allowMainThreadQueries().build()
    }

    private fun saveUsersData(userMobile: String?, userFname: String?, userLname: String?, currentDateandTime: String, message: String) {
        val messageList = MessageEntity(userFname,userLname,userMobile,currentDateandTime,message)
        historyDatabase.contactDao().insertMessage(messageList)

    }
}