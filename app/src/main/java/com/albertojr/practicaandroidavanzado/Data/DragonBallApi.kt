package com.albertojr.practicaandroidavanzado.Data

import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
//const val empa:String = "" //TOdo change
interface DragonBallApi {
    //Login
    @POST("/api/auth/login")
    //@Headers("Basic $empa")
        //According to Postman, this request do not have a Body.
    suspend fun performLogin(@Header("Authorization") loginData: String): String


    //Retrieve heroes list


    //Update heroe favourite state
}