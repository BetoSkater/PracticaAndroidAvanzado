package com.albertojr.practicaandroidavanzado.Data

class Repository {

    private val remoteDataSource = RemoteDataSource()

    suspend fun performLogin(loginData: String): String{
        return remoteDataSource.performLogin(loginData)
    }

    suspend fun getHeroes(): List<GetHeroesResponse>{
        return remoteDataSource.getHeroes()
    }

}