package com.albertojr.practicaandroidavanzado.DI

import com.albertojr.practicaandroidavanzado.Data.LocalDataSource
import com.albertojr.practicaandroidavanzado.Data.LocalDataSourceImpl
import com.albertojr.practicaandroidavanzado.Data.RemoteDataSource
import com.albertojr.practicaandroidavanzado.Data.RemoteDataSourceImpl
import com.albertojr.practicaandroidavanzado.Data.Repository
import com.albertojr.practicaandroidavanzado.Data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract  fun bindsRepository(repositoryImpl: RepositoryImpl): Repository


    @Binds
    abstract fun bindsLocalDataSource(localdataSource: LocalDataSourceImpl): LocalDataSource


    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}