package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.LocalHeroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe
import javax.inject.Inject

class LocalHeroeToHeroe @Inject constructor() {
    fun mapFromLocalHeroesToHeroes(getLocalHeroeList: List<LocalHeroe>) : List<Heroe>{
        return getLocalHeroeList.map {mapFromLocalHeroeToHeroe(it)}
    }

    private  fun mapFromLocalHeroeToHeroe(getLocalHeroe: LocalHeroe): Heroe {
        return Heroe(getLocalHeroe.id,getLocalHeroe.name,getLocalHeroe.photo, getLocalHeroe.description,getLocalHeroe.favorite)
    }

}