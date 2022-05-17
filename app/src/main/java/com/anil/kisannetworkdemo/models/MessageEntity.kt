package com.anil.kisannetworkdemo.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anil.kisannetworkdemo.utils.Constants.Companion.MESSAGE_TABLE

@Entity(tableName = MESSAGE_TABLE)
class MessageEntity(
    var fName: String? = null,
    var lName: String? = null,
    var mobile: String? = null,
    var sendTime: String? = null,
    var message: String? = null)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0
}
