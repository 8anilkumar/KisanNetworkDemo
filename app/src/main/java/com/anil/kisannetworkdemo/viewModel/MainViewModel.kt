package com.anil.kisannetworkdemo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.anil.kisannetworkdemo.data.network.Repository
import com.anil.kisannetworkdemo.models.MessageEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository, application: Application) : AndroidViewModel(application) {

    val readRecipes: LiveData<List<MessageEntity>> = repository.local.readRecipes().asLiveData()


}