package com.albertojr.practicaandroidavanzado.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HeroeDAO {
    @Query("SELECT * FROM heroes")
    fun getAll():List<LocalHeroe>

    @Query("SELECT * FROM heroes WHERE id = :heroeID")
    fun getHeroe(heroeID: String): LocalHeroe

    @Insert
    fun insertAllHeroes(heroesList: List<LocalHeroe>)

//    @Update
//    fun updateHeroeFavStateLocal(herieId: String, isFav:Boolean)
    @Query("UPDATE heroes SET favorite=:isFav WHERE id=:herieId")
    fun updateHeroeFavStateLocal(herieId: String, isFav:Boolean)
//TODO ask is update is better to change all the values but the id
}