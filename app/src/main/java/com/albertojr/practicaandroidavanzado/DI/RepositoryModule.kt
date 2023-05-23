package com.albertojr.practicaandroidavanzado.DI

import com.albertojr.practicaandroidavanzado.Data.RemoteDataSource
import com.albertojr.practicaandroidavanzado.Data.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract  fun bindsRepository(repository: Repository): Repository

    /*
    @Binds
    abstract fun bindsLocalDataSource(localdataSource: LocalDataSource): LocalDataSource
    */

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSource: RemoteDataSource): RemoteDataSource
}