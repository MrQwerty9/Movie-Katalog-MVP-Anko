package com.sstudio.moviedbmvp.network

import com.sstudio.moviedbmvp.BuildConfig.API_KEY
import com.sstudio.moviedbmvp.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String {
        return BASE_URL + API_KEY

    }
}