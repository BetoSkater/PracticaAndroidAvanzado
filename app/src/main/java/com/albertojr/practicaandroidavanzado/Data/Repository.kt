package com.albertojr.practicaandroidavanzado.Data

class Repository {

    private val remoteDataSource = RemoteDataSource()

    suspend fun performLogin(loginData: String): String{
        return remoteDataSource.performLogin(loginData)
    }

}