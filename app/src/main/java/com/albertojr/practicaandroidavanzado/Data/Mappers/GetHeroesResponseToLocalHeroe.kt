package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.Remote.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.Data.Local.LocalHeroe
import javax.inject.Inject

class GetHeroesResponseToLocalHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToLocalHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<LocalHeroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToLocalHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToLocalHeroe(getHeroeResponse: GetHeroesResponse): LocalHeroe {
        return LocalHeroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}