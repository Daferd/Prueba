package com.example.moviapp.data.remote

import com.example.moviapp.application.AppConstants
import com.example.moviapp.data.model.MovieList
import com.example.moviapp.repository.WebService

class RemoteMovieDataSource(private val webService: WebService) {
    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)
}