package com.borja.android.jetpackcomponentscatalog.model

import androidx.annotation.DrawableRes

data class Superhero(
    var superherName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
