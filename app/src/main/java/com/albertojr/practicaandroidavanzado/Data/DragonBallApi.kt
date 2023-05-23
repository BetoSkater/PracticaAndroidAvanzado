package com.albertojr.practicaandroidavanzado.Data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

//const val empa:String = "" //TOdo change
interface DragonBallApi {
    //Login
    @POST("/api/auth/login")
    //@Headers("Basic $empa")
        //According to Postman, this request do not have a Body.
    suspend fun performLogin(@Header("Authorization") loginData: String): String


    //Retrieve heroes list
    @POST("/api/heros/all")
    //Header -> inyected in use, like the login
    //Note to self: petition data = Bearer Token $TokenValue
   // This petition has a body name = "" in order to retrieve all the heroes
    suspend fun retrieveHeroes(@Header("Authorization") petitionData: String,
                               @Body getHeroesRequestBody: GetHeroesRequestBody
    ): List<GetHeroesResponse>

    //Update heroe favourite state

    @POST("/api/data/herolike")
    //Header Bearer Token $token
    //Body: Heroe id
    //This petition does not return a value.
    suspend fun heroeIsLiked(@Header("Authorization") petitionData: String)


}