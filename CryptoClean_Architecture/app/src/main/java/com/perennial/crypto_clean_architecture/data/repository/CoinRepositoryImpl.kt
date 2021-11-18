package com.perennial.crypto_clean_architecture.data.repository

import com.perennial.crypto_clean_architecture.data.remote.api.CoinApi
import com.perennial.crypto_clean_architecture.data.remote.dto.CoinDto
import com.perennial.crypto_clean_architecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }
}