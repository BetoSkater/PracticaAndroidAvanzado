package com.albertojr.practicaandroidavanzado.UI.MainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.albertojr.practicaandroidavanzado.Data.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.Data.Repository
import com.albertojr.practicaandroidavanzado.UI.Login.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//class MainActivityViewModel(private val token: String) : ViewModel() {
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository :Repository

) : ViewModel() {




    //TODO change the liveData from string list to heroesList
    //LiveData states mannagers:
    private val _heroes = MutableLiveData<List<GetHeroesResponse>>()
    val heroes: LiveData<List<GetHeroesResponse>> get () = _heroes

    //Retrieve heroes from API:

    fun getHeroes(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.getHeroes()
            }
            _heroes.value = result
        }
    }

    //TODO remove, keep just in case until it has to be removed.
     fun printToken(){
        //Log.d("MainViewModel", "The token in the MainViewModel has a value of $token")
        Log.d("MainViewModel", "The token in the MainViewModel has a value of DELETE") //TODO delete
     }

}