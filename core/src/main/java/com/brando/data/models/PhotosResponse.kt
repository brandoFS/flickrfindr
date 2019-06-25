package com.brando.data.models


data class PhotosResponse (

    val page : Int,
    val pages : Int,
    val perpage : Int,
    val total : Int,
    val photo : List<Photo>
)