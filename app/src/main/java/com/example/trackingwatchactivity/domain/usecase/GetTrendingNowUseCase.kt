package com.example.trackingwatchactivity.domain.usecase

import com.example.trackingwatchactivity.domain.model.ShowModel
import com.example.trackingwatchactivity.domain.repository.ShowRepository
import javax.inject.Inject

class GetTrendingNowUseCase @Inject constructor(
    private val repository: ShowRepository
){
    suspend fun getTrendingNowShowUseCase() : List<ShowModel>{
        return repository.getTrendingNowShows()
    }
}