package com.albertojr.practicaandroidavanzado.Data.Remote

import com.squareup.moshi.Json

data class GetLocationsResponse(
    @Json(name = "id") val id: String,
    @Json(name = "dateShow") val dateShow: String,
    @Json(name = "latitud") val latitud: Double,
    @Json(name = "longitud") val longitud: Double,
    //   @Json(name = "id") val id: String, //TODO Should I add the heroes array list?
)
