package com.albertojr.practicaandroidavanzado.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroeDAO {
    @Query("SELECT * FROM heroes")
    fun getAll():List<LocalHeroe>

    @Query("SELECT * FROM heroes WHERE id = :heroeID")
    fun getHeroe(heroeID: String): LocalHeroe

    @Insert
    fun insertAllHeroes(heroesList: List<LocalHeroe>)



}