package com.example.trackingwatchactivity.presentation.screens.discoverScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackingwatchactivity.domain.model.ShowModel
import com.example.trackingwatchactivity.domain.usecase.GetTrendingNowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DiscoverScreenViewModel @Inject constructor(
    private val getTrendingNowUseCase: GetTrendingNowUseCase
) : ViewModel(){
    private val _trendingNowShows = MutableStateFlow<List<ShowModel>>(emptyList())
    val trendingNowShows: StateFlow<List<ShowModel>> = _trendingNowShows.asStateFlow()

    init {
        getTrendingShows()
    }
    fun getTrendingShows(){
        viewModelScope.launch {
            _trendingNowShows.value = getTrendingNowUseCase.getTrendingNowShowUseCase()
        }
    }

}