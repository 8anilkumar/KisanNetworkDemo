package com.anil.kisannetworkdemo.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anil.kisannetworkdemo.utils.Constants.Companion.MESSAGE_TABLE

@Entity(tableName = MESSAGE_TABLE)
class MessageEntity(var contactModel: ContactModel) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}