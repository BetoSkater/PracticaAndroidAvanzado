package com.albertojr.practicaandroidavanzado.Data

import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSourceImpl : RemoteDataSourceImpl
): Repository
{
    override suspend fun performLogin(loginData: String): String{
        return remoteDataSourceImpl.performLogin(loginData)
    }

    override suspend fun getHeroes(): List<GetHeroesResponse>{
        return remoteDataSourceImpl.getHeroes()
    }

}