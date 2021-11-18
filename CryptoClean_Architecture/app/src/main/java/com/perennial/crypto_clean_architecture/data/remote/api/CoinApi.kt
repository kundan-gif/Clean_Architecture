package com.perennial.crypto_clean_architecture.data.remote.api

import com.perennial.crypto_clean_architecture.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>
}