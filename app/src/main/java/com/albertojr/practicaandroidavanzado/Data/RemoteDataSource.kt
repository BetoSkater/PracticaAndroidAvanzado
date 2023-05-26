package com.albertojr.practicaandroidavanzado.Data

interface RemoteDataSource {
    suspend fun performLogin(loginData:String): String

    suspend fun getHeroes(): List<GetHeroesResponse>

    suspend fun updateHeroeFavStateRemote(id:String, isFav: Boolean)

}