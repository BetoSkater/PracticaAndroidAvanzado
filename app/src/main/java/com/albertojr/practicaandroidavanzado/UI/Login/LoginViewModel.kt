package com.albertojr.practicaandroidavanzado.UI.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.practicaandroidavanzado.Data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : Repository


) : ViewModel() {


    private val _login = MutableLiveData<String>()
    val login: LiveData<String> get() = _login

    fun performLogin(email: String, password: String){
        //First the encoding must be done:

        val headerAuthorizationData = Credentials.basic(email, password)


        viewModelScope.launch {
            //I think that withContext is better than async here,
            // because until the login is done, the user can't do anything
            //Ok, is not withContext because we are not assigning it to a val.
            val result = withContext(Dispatchers.IO){
                repository.performLogin(headerAuthorizationData)
            }

            _login.value = result

        }
    }

}