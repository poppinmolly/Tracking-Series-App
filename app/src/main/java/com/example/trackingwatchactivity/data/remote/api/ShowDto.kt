package com.example.trackingwatchactivity.data.remote.api

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ShowDto(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val id: Int,
    val name: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,

)