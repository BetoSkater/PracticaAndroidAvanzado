package com.albertojr.practicaandroidavanzado.UI.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.MainActivity.MainActivity
import com.albertojr.practicaandroidavanzado.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel = LoginViewModel()
    private val TAG_TOKEN = "MyToken"
    private val TAG_PREFERENCES = "MyPreferences"

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
                launchMainActivity(it)
            }else{
                //TODO start activity sending the token or somehing, stat the activity sengind the token
                launchMainActivity(it)
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
        val sp = getSharedPreferences(TAG_PREFERENCES, MODE_PRIVATE)
        sp.edit().putString(TAG_TOKEN, token).apply()

    /*
        getPreferences(Context.MODE_PRIVATE).edit().apply(){
            putString(TAG_TOKEN, token).apply()
        }

        */
    }

    private fun checkIfTokenAlreadyExist():String{
        val sp = getSharedPreferences(TAG_PREFERENCES, MODE_PRIVATE)
        val token = sp.getString(TAG_TOKEN,"")

        token?.let {
            return token
        }
        /*
        getPreferences(Context.MODE_PRIVATE).apply {
            val token = getString(TAG_TOKEN,"")
            token?.let {
                return token.isNotEmpty()
            }
        }

         */
        return ""
    }

    private fun launchMainActivity(token: String){
        MainActivity.launch(this, token)
    }

    private fun skipLoginIfTokenExist(){
        val token = checkIfTokenAlreadyExist()
        if(token.isNotEmpty()){
            launchMainActivity(token)
        }
    }




}