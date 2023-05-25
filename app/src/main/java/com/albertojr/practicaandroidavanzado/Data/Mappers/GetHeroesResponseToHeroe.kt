package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.GetHeroesResponse
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe
import javax.inject.Inject

class GetHeroesResponseToHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<Heroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToHeroe(it)}
    }

  private  fun mapFromGetHeroeResponseToHeroe(getHeroeResponse: GetHeroesResponse): Heroe{
        return Heroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}