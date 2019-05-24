package com.sstudio.moviedbmvp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.sstudio.moviedbmvp.R
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var titleMovie: String = ""
    private var posterMovie:String = ""
    private var overviewMovie: String =""

    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        linearLayout{
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            poster = imageView {

            }.lparams{
                width = dip(250)
                gravity = Gravity.CENTER
                height = dip(250)
            }
        }
    }
}
