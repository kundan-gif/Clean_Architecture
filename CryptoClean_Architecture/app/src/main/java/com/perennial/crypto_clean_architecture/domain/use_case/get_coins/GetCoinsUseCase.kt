package com.perennial.crypto_clean_architecture.domain.use_case.get_coins

import com.perennial.crypto_clean_architecture.data.remote.dto.toCoin
import com.perennial.crypto_clean_architecture.domain.model.Coin
import com.perennial.crypto_clean_architecture.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(

    private val repository: CoinRepository

) {

    suspend operator fun invoke(): List<Coin> {

        return repository.getCoins().map { it.toCoin() }
    }


}