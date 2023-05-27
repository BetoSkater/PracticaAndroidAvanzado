package com.albertojr.practicaandroidavanzado.Data.Mappers

import com.albertojr.practicaandroidavanzado.Data.Local.LocalHeroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Model.Heroe
import javax.inject.Inject

class LocalHeroeToHeroe @Inject constructor() {
    fun mapFromLocalHeroesToHeroes(getLocalHeroeList: List<LocalHeroe>) : List<Heroe>{
        return getLocalHeroeList.map {mapFromLocalHeroeToHeroe(it)}
    }

    fun mapFromLocalHeroeToHeroe(getLocalHeroe: LocalHeroe): Heroe {
        return Heroe(getLocalHeroe.id,getLocalHeroe.name,getLocalHeroe.photo, getLocalHeroe.description,getLocalHeroe.favorite)
    }

}