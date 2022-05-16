package com.anil.kisannetworkdemo.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anil.kisannetworkdemo.models.MessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(contactEntity: MessageEntity)

    @Query("SELECT * FROM message_table ORDER BY id ASC")
    fun readMessage(): Flow<List<MessageEntity>>

}