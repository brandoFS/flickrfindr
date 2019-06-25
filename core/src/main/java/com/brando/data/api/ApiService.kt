package com.brando.data.api

import com.brando.data.models.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal const val URLS = "url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o"

interface ApiService {


    @GET("?method=flickr.photos.search&nojsoncallback=1&format=json")
    suspend fun search(
        @Query("text") text: String,
        @Query("extras") extras: String = URLS
    ): Response<PhotosResponse>
}

