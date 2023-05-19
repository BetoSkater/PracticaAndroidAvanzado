package com.albertojr.practicaandroidavanzado.UI.MainActivity

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val token: String) : ViewModel() {

     fun printToken(){
         Log.d("MainViewModel", "The token in the MainViewModel has a value of $token")
     }
}