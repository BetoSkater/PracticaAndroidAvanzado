package com.albertojr.practicaandroidavanzado.Data

import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe

interface Repository {
    suspend fun performLogin(loginData: String): String
    suspend fun getHeroes(): List<Heroe>

    suspend fun  getHeroe(id:String): Heroe

    suspend fun  updateHeroeFavStateLocalAndRemote(id: String, isFav:Boolean)
}