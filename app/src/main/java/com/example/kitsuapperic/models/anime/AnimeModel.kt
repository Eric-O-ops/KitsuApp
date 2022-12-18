package com.example.kitsuapperic.models.anime

import com.example.kitsuapperic.base.BaseDiffUtil
import com.example.kitsuapperic.models.AttributesModel
import com.google.gson.annotations.SerializedName

data class AnimeModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("type")
    val manga: String?,

    @SerializedName("attributes")
    val attributes: AttributesModel,

): BaseDiffUtil
