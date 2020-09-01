package com.bsrakdg.hiltmvibasicsample.di

import com.bsrakdg.hiltmvibasicsample.network.BlogNetwork
import com.bsrakdg.hiltmvibasicsample.network.NetworkMapper
import com.bsrakdg.hiltmvibasicsample.persistence.BlogDao
import com.bsrakdg.hiltmvibasicsample.persistence.CacheMapper
import com.bsrakdg.hiltmvibasicsample.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogNetwork: BlogNetwork,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(
            blogDao = blogDao,
            blogNetwork = blogNetwork,
            cacheMapper = cacheMapper,
            networkMapper = networkMapper
        )
    }
}