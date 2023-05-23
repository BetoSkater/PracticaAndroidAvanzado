package com.albertojr.practicaandroidavanzado.Data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
class RemoteDataSource {

    private lateinit var token: String

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        .apply{
            level = HttpLoggingInterceptor.Level.BASIC
    }).build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://dragonball.keepcoding.education")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    private val api: DragonBallApi = retrofit.create(DragonBallApi::class.java)




    suspend fun performLogin(loginData:String): String{
        this.token = api.performLogin(loginData)
       return token
    }

    suspend fun getHeroes(): List<GetHeroesResponse>{
       token?.let {
           val requestData = "Bearer $token"
           return api.retrieveHeroes(requestData, GetHeroesRequestBody())
       }
        return mutableListOf() //TODO arreglar
    }



}