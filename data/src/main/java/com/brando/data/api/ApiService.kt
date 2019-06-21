package com.brando.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("market-price")
    fun getMarketPrices() : Single<String>
}
