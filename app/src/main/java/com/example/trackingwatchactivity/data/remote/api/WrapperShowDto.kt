package com.example.trackingwatchactivity.data.remote.api

import kotlinx.serialization.Serializable

@Serializable
data class WrapperShowDto(
    val page: Int,
    val results: List<ShowDto>
)