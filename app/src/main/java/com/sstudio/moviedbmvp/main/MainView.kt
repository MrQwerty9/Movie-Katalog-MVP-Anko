package com.sstudio.moviedbmvp.main

import com.sstudio.moviedbmvp.model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}