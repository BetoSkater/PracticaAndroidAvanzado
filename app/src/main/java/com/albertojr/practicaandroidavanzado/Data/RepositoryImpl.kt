package com.albertojr.practicaandroidavanzado.Data

import com.albertojr.practicaandroidavanzado.Data.Mappers.GetHeroesResponseToHeroe
import com.albertojr.practicaandroidavanzado.Data.Mappers.GetHeroesResponseToLocalHeroe
import com.albertojr.practicaandroidavanzado.Data.Mappers.LocalHeroeToHeroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource : RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val getHeroesResponseToHeroe: GetHeroesResponseToHeroe,
    private val localHeroeToHeroe: LocalHeroeToHeroe,
    private val getHeroesResponseToLocalHeroe: GetHeroesResponseToLocalHeroe
): Repository
{
    //Remote methods
    override suspend fun performLogin(loginData: String): String{
        return remoteDataSource.performLogin(loginData)
    }

    override suspend fun getHeroes(): List<Heroe>{
        if(localDataSource.getHeroes().isEmpty()){
            localDataSource.insertHeroes(getHeroesResponseToLocalHeroe.mapFromGetHeroesResponsesToLocalHeroes(remoteDataSource.getHeroes()))
            return getHeroesResponseToHeroe.mapFromGetHeroesResponsesToHeroes(remoteDataSource.getHeroes())
        }
        return localHeroeToHeroe.mapFromLocalHeroesToHeroes(localDataSource.getHeroes())
    }

    override suspend fun getHeroe(id: String): Heroe {
        return localHeroeToHeroe.mapFromLocalHeroeToHeroe(localDataSource.getHeroe(id))
    }

}