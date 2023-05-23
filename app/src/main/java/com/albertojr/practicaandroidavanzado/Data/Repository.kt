package com.albertojr.practicaandroidavanzado.Data

import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource : RemoteDataSource
)
{
    suspend fun performLogin(loginData: String): String{
        return remoteDataSource.performLogin(loginData)
    }

    suspend fun getHeroes(): List<GetHeroesResponse>{
        return remoteDataSource.getHeroes()
    }

}