package com.albertojr.practicaandroidavanzado.Data

import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: HeroeDAO): LocalDataSource {
    override suspend fun getHeroes(): List<LocalHeroe> {
        return dao.getAll()
    }

    override suspend fun insertHeroes(localHeroes: List<LocalHeroe>) {
        dao.insertAllHeroes(localHeroes)
    }

}