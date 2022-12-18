package com.example.kitsuapperic

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setupImageWithGlide(picture: String) {
    Glide.with(this).load(picture).into(this)
}




