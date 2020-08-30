package com.bsrakdg.hiltmvibasicsample.network

import retrofit2.http.GET

interface BlogNetwork {

    @GET("blogs")
    suspend fun getBlogs(): List<BlogNetworkEntity>
}