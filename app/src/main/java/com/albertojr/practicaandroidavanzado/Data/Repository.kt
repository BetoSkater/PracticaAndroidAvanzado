package com.albertojr.practicaandroidavanzado.Data

interface Repository {
    suspend fun performLogin(loginData: String): String
    suspend fun getHeroes(): List<GetHeroesResponse>
}