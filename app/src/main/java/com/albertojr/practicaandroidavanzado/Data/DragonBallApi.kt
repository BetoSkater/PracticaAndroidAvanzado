package com.albertojr.practicaandroidavanzado.Data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
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
   // @Headers("Authorization: Bearer eyJraWQiOiJwcml2YXRlIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJlbWFpbCI6ImFsYmVydG9qdW5xdWVyYS5yYUBnbWFpbC5jb20iLCJleHBpcmF0aW9uIjo2NDA5MjIxMTIwMCwiaWRlbnRpZnkiOiI5ODJEOTQ1OC02NDYyLTRCOUItOThEOC1GQ0Y5NDU1RkE0N0YifQ.XmMj6F3Ir4JhiiG89JxVqjDu_npoe-ZldzMJB3LDU1E")
  //  suspend fun retrieveHeroes(@Body getHeroesRequestBody: GetHeroesRequestBody): List<GetHeroesResponse>

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