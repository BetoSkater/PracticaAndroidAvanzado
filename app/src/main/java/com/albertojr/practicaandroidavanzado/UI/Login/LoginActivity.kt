package com.albertojr.practicaandroidavanzado.UI.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.databinding.ActivityLoginBinding
import com.albertojr.practicaandroidavanzado.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieving performLogin result
        viewModel.login.observe(this){
            Log.d("LOGIN", it.toString())
        }

        binding.btLogin.setOnClickListener{
            //TODO add validations

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.performLogin(email,password)
        }

    }
    //Method to try to retrieve a stored token from SharedPrefferences
    //TODO save the token in preferences in the companion object from the mainActivity.
}