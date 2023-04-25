package com.example.moviapp.repository

import com.example.moviapp.data.model.MovieList
import com.example.moviapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(private val dataSource:RemoteMovieDataSource):MovieRepository {
    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}