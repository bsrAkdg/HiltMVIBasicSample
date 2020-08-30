package com.bsrakdg.hiltmvibasicsample.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// This is the same with API looks like
class BlogNetworkEntity(
    @SerializedName("pk")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("category")
    @Expose
    var category: String
)