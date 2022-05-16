package com.anil.kisannetworkdemo.data.network

import com.anil.kisannetworkdemo.models.MessageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val contactDao: ContactDao) {

    fun readRecipes(): Flow<List<MessageEntity>> {
        return contactDao.readMessage()
    }

    suspend fun insertRecipes(recipesEntity: MessageEntity) {
        contactDao.insertMessage(recipesEntity)
    }

}