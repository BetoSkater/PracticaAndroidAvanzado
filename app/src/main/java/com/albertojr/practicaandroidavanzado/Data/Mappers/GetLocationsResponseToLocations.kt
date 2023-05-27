package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.Remote.GetLocationsResponse
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Model.Location
import javax.inject.Inject

class GetLocationsResponseToLocations @Inject constructor() {
    fun mapFromGetLocationsResponseToLocations(getLocationsResponseList: List<GetLocationsResponse>) : List<Location>{
        return getLocationsResponseList.map {mspFromGetLocationResponseToLocation(it)}
    }

    private  fun mspFromGetLocationResponseToLocation(getLocationResponse: GetLocationsResponse): Location {
        return Location(getLocationResponse.id, getLocationResponse.dateShow,getLocationResponse.latitud,getLocationResponse.longitud)
    }

}