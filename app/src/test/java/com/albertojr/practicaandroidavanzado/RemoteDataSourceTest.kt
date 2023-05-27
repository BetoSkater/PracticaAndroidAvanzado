package com.albertojr.practicaandroidavanzado

import com.albertojr.practicaandroidavanzado.Data.Remote.RemoteDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RemoteDataSourceTest: BaseNetworkMockTest() {

    @Test
    fun `WHEN performing performLogin EXPECT successful response AND a token`() = runTest {
        //GIVEN:
        val remoteDataSource = RemoteDataSourceImpl(api)

        //WHEN:
        val token = remoteDataSource.performLogin("Basic ....")

        //
        assert(token.isNotEmpty())
    }

}