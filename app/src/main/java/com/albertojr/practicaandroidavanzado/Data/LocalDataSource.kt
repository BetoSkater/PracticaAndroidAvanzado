package com.albertojr.practicaandroidavanzado.Data

interface LocalDataSource {

    suspend fun getHeroes(): List<LocalHeroe>

    suspend fun insertHeroes(localHeroes: List<LocalHeroe>)

    //TODO add more methods in here

    suspend fun getHeroe(id: String): LocalHeroe

    suspend fun updateHeroeFavStateLocal(id: String, isFav: Boolean)

}