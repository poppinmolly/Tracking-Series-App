package com.example.trackingwatchactivity.data.mapper

import com.example.trackingwatchactivity.data.remote.api.ShowDto
import com.example.trackingwatchactivity.domain.model.ShowModel
import kotlin.Int

fun ShowDto.toUiModel() = ShowModel(
    id = id,
    name = name ?: title ?: "Unknown",
    overview = overview?: "Unknown",
    genreIds = genreIds ?: emptyList(),
    voteAverage = voteAverage?.let{"%.1f".format(it)} ?: "?",
    posterPath = "https://image.tmdb.org/t/p/w500${posterPath ?: ""}",
    date = releaseDate?.take(4) ?: "Unknown",
    title = name ?: title ?: "Unknown"
)