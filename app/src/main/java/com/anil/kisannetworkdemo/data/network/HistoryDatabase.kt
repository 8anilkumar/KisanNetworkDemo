package com.anil.kisannetworkdemo.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anil.kisannetworkdemo.models.MessageEntity
import com.anil.kisannetworkdemo.utils.MessageTypeConverter

@Database(entities = [MessageEntity::class], version = 1, exportSchema = false)
@TypeConverters(MessageTypeConverter::class)
abstract class HistoryDatabase: RoomDatabase() {
    abstract fun recipesDao(): ContactDao
}