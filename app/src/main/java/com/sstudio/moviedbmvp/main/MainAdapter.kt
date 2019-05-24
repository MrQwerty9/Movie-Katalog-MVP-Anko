package com.sstudio.moviedbmvp.main

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sstudio.moviedbmvp.BuildConfig.URL_POSTER
import com.sstudio.moviedbmvp.R
import com.sstudio.moviedbmvp.R.id.iv_moviePoster
import com.sstudio.moviedbmvp.R.id.tv_movieTittle
import com.sstudio.moviedbmvp.model.Movie
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(private val result: List<Movie>, private val listener: (Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(result[position], listener)
    }
}

class MovieUI: AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout{
                lparams(width = matchParent, height = wrapContent)
                padding = dip(5)
                orientation = LinearLayout.VERTICAL

                imageView{
                    id = R.id.iv_moviePoster
                }.lparams{
                    height = dip(250)
                    width = wrapContent
                }

                textView{
                    id = R.id.tv_movieTittle
                    textSize = 16f
                }.lparams{
                    margin = dip(16)
                }
            }
        }
    }
}

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val moviePoster: ImageView = view.find(iv_moviePoster)
    private val movieTittle: TextView = view.find(tv_movieTittle)

    fun bindItem(movie: Movie, listener: (Movie) -> Unit){
        Picasso.get().load(URL_POSTER + movie.poster).into(moviePoster)
        movieTittle.text = movie.title

        moviePoster.onClick {
            listener(movie)
        }
    }
}
