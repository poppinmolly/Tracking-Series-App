package com.example.trackingwatchactivity.data.remote.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ShowDto(
    @SerialName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    val name: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("genre_ids")
    val genreIds: List<Long>,
    @SerialName("vote_average")
    val voteAverage: Double,

)