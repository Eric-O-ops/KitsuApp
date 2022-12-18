package com.example.kitsuapperic.models

import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(

    @SerializedName("data")
    val data: List<T>,

    @SerializedName("links")
    val links: LinksModel

)