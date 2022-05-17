package com.anil.kisannetworkdemo.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anil.kisannetworkdemo.models.MessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    fun insertMessage(contactEntity: MessageEntity)

    @Query("SELECT * FROM message_table")
    fun readMessage(): Flow<List<MessageEntity>>

}