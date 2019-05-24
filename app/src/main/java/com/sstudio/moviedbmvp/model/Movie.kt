package com.sstudio.moviedbmvp.model

import com.google.gson.annotations.SerializedName

data class Movie (
    var id: String,
    var title: String,
    var overview: String,
    @SerializedName("poster_path") var poster: String
)