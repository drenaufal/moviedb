package com.ioase.network

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("release_date")
    val release_date: String
)
