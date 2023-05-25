package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.Data.LocalHeroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe
import javax.inject.Inject

class GetHeroesResponseToLocalHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToLocalHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<LocalHeroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToLocalHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToLocalHeroe(getHeroeResponse: GetHeroesResponse): LocalHeroe {
        return LocalHeroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}