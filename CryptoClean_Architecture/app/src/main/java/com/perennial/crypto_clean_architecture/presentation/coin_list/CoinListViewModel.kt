package com.perennial.crypto_clean_architecture.presentation.coin_list


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perennial.crypto_clean_architecture.domain.model.Coin
import com.perennial.crypto_clean_architecture.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinsLiveData: MutableLiveData<List<Coin>> = MutableLiveData()
    fun getCoinsLivedata() = _coinsLiveData

    init {
        viewModelScope.launch {
            getCoins()
        }

    }

    private suspend fun getCoins() {

        val coins = getCoinsUseCase()
        _coinsLiveData.value = coins

    }
}