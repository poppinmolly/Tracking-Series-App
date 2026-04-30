package com.example.trackingwatchactivity.domain.repository

import com.example.trackingwatchactivity.data.remote.api.ShowDto
import com.example.trackingwatchactivity.domain.model.ShowModel

interface ShowRepository {
    suspend fun getTrendingNowShows(): List<ShowModel>
}