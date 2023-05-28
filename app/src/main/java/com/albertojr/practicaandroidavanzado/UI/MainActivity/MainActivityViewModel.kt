package com.albertojr.practicaandroidavanzado.UI.MainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.practicaandroidavanzado.Data.RepositoryImpl
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Model.Heroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//class MainActivityViewModel(private val token: String) : ViewModel() {
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repositoryImpl :RepositoryImpl
) : ViewModel() {


    //LiveData states mannagers:
    //HeroesList
    private val _heroes = MutableLiveData<List<Heroe>>()
    val heroes: LiveData<List<Heroe>> get () = _heroes

    //HeroeDetail
    private val _heroe = MutableLiveData<Heroe>()
    val heroe : LiveData<Heroe> get () = _heroe

    //HeroeLocations
    private val _locations = MutableLiveData<List<Location>>()
    val locations : LiveData<List<Location>> get () = _locations

    //Retrieve heroes from API:

    fun getHeroes(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.getHeroes()
            }
            _heroes.value = result
        }
    }

    //Retrieve heroe with id

    fun getHeroe(id: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.getHeroe(id)
            }
            _heroe.value = result //TODO check later after setting all the methods
        }
    }

    fun updateHeroeFavStateLocalAndRemote(id: String, isFav: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.updateHeroeFavStateLocalAndRemote(id, isFav)
        }
    }

    fun retrieveHeroeLocations(id: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.retrieveHeroeLocations(id)
            }
            if (result.isNotEmpty()){
                _locations.value = result
            }

        }

    }

    //TODO remove, keep just in case until it has to be removed.
     fun printToken(){
        //Log.d("MainViewModel", "The token in the MainViewModel has a value of $token")
        Log.d("MainViewModel", "The token in the MainViewModel has a value of DELETE") //TODO delete
     }



}