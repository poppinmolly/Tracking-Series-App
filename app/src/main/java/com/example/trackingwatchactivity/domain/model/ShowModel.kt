package com.example.trackingwatchactivity.domain.model

data class ShowModel(
    val id: Int,
    val name: String,
    val overview: String,
    val genreIds: List<Int>,
    val voteAverage: Long,
    val posterPath: String,
    val date: String,

)