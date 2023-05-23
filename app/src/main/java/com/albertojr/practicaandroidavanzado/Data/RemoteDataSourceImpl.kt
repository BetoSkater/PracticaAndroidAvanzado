package com.albertojr.practicaandroidavanzado.Data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
  //  private val moshi :
  //  private val okHttpClient =
// private val retrofit =
private val api: DragonBallApi
) : RemoteDataSource{

    private lateinit var token: String

    override suspend fun performLogin(loginData:String): String{
        this.token = api.performLogin(loginData)
       return token
    }

    override suspend fun getHeroes(): List<GetHeroesResponse>{
       token?.let {
           val requestData = "Bearer $token"
           return api.retrieveHeroes(requestData, GetHeroesRequestBody())
       }
        return mutableListOf() //TODO arreglar
    }



}