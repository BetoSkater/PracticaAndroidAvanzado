package com.albertojr.practicaandroidavanzado.Data.Remote

import com.albertojr.practicaandroidavanzado.Data.Remote.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.Data.Remote.GetLocationsResponse

interface RemoteDataSource {
    suspend fun performLogin(loginData:String): String

    suspend fun getHeroes(): List<GetHeroesResponse>

    suspend fun updateHeroeFavStateRemote(id:String, isFav: Boolean)

    suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse>

}