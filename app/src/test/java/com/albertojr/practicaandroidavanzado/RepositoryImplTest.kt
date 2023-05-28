package com.albertojr.practicaandroidavanzado

import android.util.Log
import com.albertojr.practicaandroidavanzado.Data.Local.LocalDataSource
import com.albertojr.practicaandroidavanzado.Data.Local.LocalDataSourceImpl
import com.albertojr.practicaandroidavanzado.Data.Mappers.GetHeroesResponseToHeroe
import com.albertojr.practicaandroidavanzado.Data.Mappers.GetHeroesResponseToLocalHeroe
import com.albertojr.practicaandroidavanzado.Data.Mappers.GetLocationsResponseToLocations
import com.albertojr.practicaandroidavanzado.Data.Mappers.LocalHeroeToHeroe
import com.albertojr.practicaandroidavanzado.Data.Remote.RemoteDataSource
import com.albertojr.practicaandroidavanzado.Data.RepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {

    private lateinit var repositoryImpl: RepositoryImpl
    private lateinit var remoteDataSource: FakeRemoteDataSource

    private lateinit var  localDataSource: LocalDataSource
    private lateinit var getHeroesResponseToHeroe: GetHeroesResponseToHeroe
    private lateinit var localHeroeToHeroe: LocalHeroeToHeroe
    private lateinit var getHeroesResponseToLocalHeroe: GetHeroesResponseToLocalHeroe
    private lateinit var getLocationsResponseToLocations: GetLocationsResponseToLocations

    @Before
    fun setup(){
        remoteDataSource = FakeRemoteDataSource()
        localDataSource = FakeLocalDataSource()
        getHeroesResponseToHeroe = GetHeroesResponseToHeroe()
        localHeroeToHeroe = LocalHeroeToHeroe()
        getHeroesResponseToLocalHeroe = GetHeroesResponseToLocalHeroe()
        getLocationsResponseToLocations = GetLocationsResponseToLocations()
        repositoryImpl = RepositoryImpl(remoteDataSource,
            localDataSource,
            getHeroesResponseToHeroe,
            localHeroeToHeroe,
            getHeroesResponseToLocalHeroe,
            getLocationsResponseToLocations)
    }

    @Test
    fun `(FAKE TEST)WHEN performLoging EXPECT succesfull response and token `() = runTest{
        coEvery { remoteDataSource.performLogin("dfgsdf") } returns generateFakeToken()
        val token = repositoryImpl.performLogin("asas")
        assert(token.isNotEmpty())
    }

    @Test
    fun `generated token `() = runTest{
        var token = coEvery {remoteDataSource.performLogin("asass") } returns generateFakeToken2().toString()
       // val token = repositoryImpl.performLogin("aaa")
        Log.d("Test", token.toString())
        assert(token.toString().isNotEmpty())
    }

}