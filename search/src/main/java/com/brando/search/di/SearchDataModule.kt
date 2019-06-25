package com.brando.search.di

import com.brando.data.api.ApiService
import com.brando.data.repository.search.SearchRemoteDataSource
import com.brando.data.repository.search.SearchRepository
import dagger.Module
import dagger.Provides

@Module
open class SearchDataModule {
    @Provides
    fun provideSearchRepository(
        searchRemoteDataSource: SearchRemoteDataSource
    ): SearchRepository =
        SearchRepository.getInstance(searchRemoteDataSource)

    @Provides
    fun provideSearchRemoteDataSource(service: ApiService): SearchRemoteDataSource =
        SearchRemoteDataSource.getInstance(service)

}