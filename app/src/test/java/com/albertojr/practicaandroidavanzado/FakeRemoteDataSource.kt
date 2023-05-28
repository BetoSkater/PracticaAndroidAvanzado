package com.albertojr.practicaandroidavanzado

import com.albertojr.practicaandroidavanzado.Data.Remote.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.Data.Remote.GetLocationsResponse
import com.albertojr.practicaandroidavanzado.Data.Remote.RemoteDataSource

class FakeRemoteDataSource: RemoteDataSource {
    override suspend fun performLogin(loginData: String): String {
        return generateFakeToken2()
    }

    override suspend fun getHeroes(): List<GetHeroesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun updateHeroeFavStateRemote(id: String, isFav: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse> {
        TODO("Not yet implemented")
    }


}