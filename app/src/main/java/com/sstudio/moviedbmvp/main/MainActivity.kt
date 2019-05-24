package com.sstudio.moviedbmvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sstudio.moviedbmvp.R
import com.sstudio.moviedbmvp.detail.DetailActivity
import com.sstudio.moviedbmvp.model.Movie
import com.sstudio.moviedbmvp.network.ApiRepository
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var listMovie: RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var movie: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout{
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            listMovie = recyclerView{
                lparams(width = matchParent, height = wrapContent)
                layoutManager = GridLayoutManager(ctx, 2)
            }
        }

        adapter = MainAdapter(movie){
            startActivity<DetailActivity>()
            "TITLE" to it.title
            "POSTER" to it.poster
            "OVERVIEW" to it.overview
        }

        listMovie.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()
        Log.i("MainActivity","main")
    }

    override fun showMovieList(data: List<Movie>){
        movie.clear()
        movie.addAll(data)
        adapter.notifyDataSetChanged()
        Log.d("MainActivity", "data: $data")
    }
}
