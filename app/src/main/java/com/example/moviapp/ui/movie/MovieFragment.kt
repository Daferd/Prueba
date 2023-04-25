package com.example.moviapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.moviapp.R
import com.example.moviapp.core.Resource
import com.example.moviapp.data.remote.RemoteMovieDataSource
import com.example.moviapp.databinding.FragmentMovieBinding
import com.example.moviapp.presentation.MovieViewModel
import com.example.moviapp.presentation.MovieViewModelFactory
import com.example.moviapp.repository.MovieRepositoryImpl
import com.example.moviapp.repository.RetrofitClient


class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImpl(
                RemoteMovieDataSource(
                    RetrofitClient.webservice
                )
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading->{
                    Log.d("LiveData","Loading...")
                }
                is Resource.Success->{
                    Log.d("LiveData","${result.data.first}")

                }
                is Resource.Failure->{
                    Log.d("Error","${result.exception}")

                }
            }
        })

    }

}