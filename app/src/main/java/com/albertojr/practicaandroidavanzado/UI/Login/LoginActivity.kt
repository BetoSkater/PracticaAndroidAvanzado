package com.albertojr.practicaandroidavanzado.UI.Login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.BaseActivity.MainActivity
import com.albertojr.practicaandroidavanzado.databinding.ActivityLoginBinding
import com.albertojr.practicaandroidavanzado.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel = LoginViewModel()
    private val TAG_TOKEN = "MyToken"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        skipLoginIfTokenExist()

        //Retrieving performLogin result
        viewModel.login.observe(this){
            Log.d("LOGIN", it.toString())
            if(binding.cbSaveData.isChecked){
                saveTokenInSharedPreferences(it)
                launchMainActivity()
            }
        }

        binding.btLogin.setOnClickListener{
            //TODO add validations
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(!email.isEmpty() && !password.isEmpty()){
                viewModel.performLogin(email,password)

            }else{
                binding.etEmail.setError("This field is empty or the email is invalid")
                //TODO set more validations in case email or password are incorreect
            }

        }

    }
    //Method to try to retrieve a stored token from SharedPrefferences
    //TODO save the token in preferences in the companion object from the mainActivity.
    private fun saveTokenInSharedPreferences(token: String) {
        getPreferences(Context.MODE_PRIVATE).edit().apply(){
            putString(TAG_TOKEN, token).apply()
        }
    }

    private fun checkIfTokenAlreadyExist():Boolean{
        getPreferences(Context.MODE_PRIVATE).apply {
            val token = getString(TAG_TOKEN,"")
            token?.let {
                return token.isNotEmpty()
            }
        }
        return false
    }

    private fun launchMainActivity(){
        MainActivity.launch(this)
    }

    private fun skipLoginIfTokenExist(){
        if(checkIfTokenAlreadyExist()){
            launchMainActivity()
        }
    }
}