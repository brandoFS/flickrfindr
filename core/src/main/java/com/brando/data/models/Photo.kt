package com.brando.data.models

data class Photo (

    val id : Int,
    val owner : String,
    val secret : String,
    val server : Int,
    val farm : Int,
    val title : String,
    val ispublic : Int,
    val isfriend : Int,
    val isfamily : Int
)