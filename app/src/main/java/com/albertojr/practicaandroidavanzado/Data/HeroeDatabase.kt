package com.albertojr.practicaandroidavanzado.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalHeroe::class], version = 1)
abstract class HeroeDatabase :RoomDatabase(){
    abstract fun heroeDao(): HeroeDAO
}