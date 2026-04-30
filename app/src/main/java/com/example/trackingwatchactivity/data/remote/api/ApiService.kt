package com.example.trackingwatchactivity.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/all/day")
    suspend fun getTrending(
        @Query("api_key") apiKey:  String = API_KEY
    ): WrapperShowDto
}