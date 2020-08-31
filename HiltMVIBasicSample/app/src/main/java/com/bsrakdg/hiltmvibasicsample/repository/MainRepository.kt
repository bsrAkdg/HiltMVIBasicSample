package com.bsrakdg.hiltmvibasicsample.repository

import com.bsrakdg.hiltmvibasicsample.model.Blog
import com.bsrakdg.hiltmvibasicsample.network.BlogNetwork
import com.bsrakdg.hiltmvibasicsample.network.NetworkMapper
import com.bsrakdg.hiltmvibasicsample.persistence.BlogDao
import com.bsrakdg.hiltmvibasicsample.persistence.CacheMapper
import com.bsrakdg.hiltmvibasicsample.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogNetwork: BlogNetwork,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)

        try {
            val networkBlogList = blogNetwork.getBlogs() // retrieve from network
            val blogList = networkMapper.mapFromEntityList(networkBlogList)
            blogList.map { blog ->
                blogDao.insert(cacheMapper.mapToEntity(blog)) // save to cache
            }

            val cachedBlogList = blogDao.getBlogs() // read from cache
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogList)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }
}
