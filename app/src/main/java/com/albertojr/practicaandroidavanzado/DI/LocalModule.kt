package com.albertojr.practicaandroidavanzado.DI

import android.content.Context
import androidx.room.Room
import com.albertojr.practicaandroidavanzado.Data.HeroeDAO
import com.albertojr.practicaandroidavanzado.Data.HeroeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun privideHeroeDatabase(@ApplicationContext context: Context): HeroeDatabase{
        return Room.databaseBuilder(
            context,
            HeroeDatabase::class.java, "heroe-db"
        ).build()
    }

    @Provides
    fun provideDAO(db: HeroeDatabase): HeroeDAO{
        return db.heroeDao()
    }

}