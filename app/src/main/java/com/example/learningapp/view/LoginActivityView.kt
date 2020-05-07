package com.example.learningapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningapp.R
import com.example.learningapp.viewmodel.LoginActivityViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivityView : AppCompatActivity() {

    private lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //init viewmodel here
        viewModel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)
        btn_login.setOnClickListener {
            Log.d("Login", "login here")
            if (isValidData()) {
                // request login firebase here
                viewModel.requestLogin(edt_email.text.toString(), edt_password.text.toString())
            }
        }
        viewModel.isSuccessful.observe(this, Observer {
            //handle
            var message = ""
            if (it) {
                message = "Đăng nhập thành công!"
            } else {
                message = "Đăng nhập thất bại!"
            }
            Toast.makeText(application, message, Toast.LENGTH_LONG).show()
        })
    }

    // check valid data
// true valid - failed invalid
    private fun isValidData(): Boolean {
        if (edt_email.text.isNullOrEmpty() || edt_password.text.isNullOrEmpty()) {
            return false
        }
        return true
    }
}

