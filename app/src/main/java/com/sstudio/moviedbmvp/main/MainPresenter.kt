package com.sstudio.moviedbmvp.main

import android.util.Log
import com.google.gson.Gson
import com.sstudio.moviedbmvp.model.MovieResponse
import com.sstudio.moviedbmvp.network.ApiRepository
import com.sstudio.moviedbmvp.network.TMDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson) {

    fun getMovieList(){
        doAsync {
//            Log.i("MainPresenter", "doAsyic")
            val data = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()), MovieResponse::class.java)

            uiThread {
                Log.d("MainPresenter", "uiThread")
                view.showMovieList(data.results)

            }

        }
        Log.i("MainPresenter","Main")
    }
}