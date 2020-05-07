package com.example.learningapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learningapp.repository.LoginActivityRepository

class LoginActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LoginActivityRepository(application)
    val isSuccessful: LiveData<Boolean>

    init {
        isSuccessful = repository.isSuccessful
    }

    //request login to firebase
    fun requestLogin(email: String, password: String) {
        repository.requestLogin(email, password)
    }
}