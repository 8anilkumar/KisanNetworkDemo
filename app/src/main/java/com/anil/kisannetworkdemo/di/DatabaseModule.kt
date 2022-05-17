package com.anil.kisannetworkdemo.di

import android.content.Context
import androidx.room.Room
import com.anil.kisannetworkdemo.data.network.HistoryDatabase
import com.anil.kisannetworkdemo.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, HistoryDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: HistoryDatabase) = database.contactDao()

}