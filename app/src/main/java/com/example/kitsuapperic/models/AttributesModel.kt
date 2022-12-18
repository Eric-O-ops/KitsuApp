package com.example.kitsuapperic.models

import com.google.gson.annotations.SerializedName

data class AttributesModel(

    @SerializedName("titles")
    val titles: TitleModel,

    @SerializedName("posterImage")
    val posterImage: PosterImageModel?,
)
