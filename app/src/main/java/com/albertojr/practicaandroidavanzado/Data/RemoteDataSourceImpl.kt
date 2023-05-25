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
        /*token?.let {
            if(token.isNotEmpty()){
                val requestData = "Bearer $token"
               // return api.retrieveHeroes(requestData, GetHeroesRequestBody())
            }else{
                return mutableListOf()
            }

       }
        return mutableListOf()


         */
        val requestDAta = "Bearer eyJraWQiOiJwcml2YXRlIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJlbWFpbCI6ImFsYmVydG9qdW5xdWVyYS5yYUBnbWFpbC5jb20iLCJleHBpcmF0aW9uIjo2NDA5MjIxMTIwMCwiaWRlbnRpZnkiOiI5ODJEOTQ1OC02NDYyLTRCOUItOThEOC1GQ0Y5NDU1RkE0N0YifQ.XmMj6F3Ir4JhiiG89JxVqjDu_npoe-ZldzMJB3LDU1E"

        return api.retrieveHeroes(requestDAta,GetHeroesRequestBody())

    }



}