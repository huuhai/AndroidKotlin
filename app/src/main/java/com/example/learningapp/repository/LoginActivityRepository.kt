package com.example.learningapp.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth;

class LoginActivityRepository(val application: Application) {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val isSuccessful = MutableLiveData<Boolean>()

    fun requestLogin(email: String, password: String) {
        //call firebase service
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("Login", "login success")
                    isSuccessful.value= it.isSuccessful
                } else {
                    Log.d("Login", "login failed")
                    isSuccessful.value = false
                }
            }
    }
}