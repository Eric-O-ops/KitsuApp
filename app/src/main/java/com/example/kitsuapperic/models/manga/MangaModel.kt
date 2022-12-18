package com.example.kitsuapperic.models.manga

import com.example.kitsuapperic.base.BaseDiffUtil
import com.example.kitsuapperic.models.AttributesModel
import com.google.gson.annotations.SerializedName

data class MangaModel (

@SerializedName("id")
override val id: Int,

@SerializedName("type")
val manga: String?,

@SerializedName("attributes")
val attributes: AttributesModel,

): BaseDiffUtil
