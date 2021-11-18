package com.perennial.crypto_clean_architecture.domain.repository

import com.perennial.crypto_clean_architecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
}