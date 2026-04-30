package com.example.trackingwatchactivity.data.repository

import com.example.trackingwatchactivity.data.mapper.toUiModel
import com.example.trackingwatchactivity.data.remote.api.ApiService
import com.example.trackingwatchactivity.data.remote.api.ShowDto
import com.example.trackingwatchactivity.domain.model.ShowModel
import com.example.trackingwatchactivity.domain.repository.ShowRepository
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    val apiService: ApiService
): ShowRepository {
    override suspend fun getTrendingNowShows() : List<ShowModel> {
        return apiService.getTrending()
            .results
            .map { it.toUiModel() }
    }
}