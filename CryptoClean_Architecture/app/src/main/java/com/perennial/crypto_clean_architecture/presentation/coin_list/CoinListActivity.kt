package com.perennial.crypto_clean_architecture.presentation.coin_list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.perennial.crypto_clean_architecture.R
import com.perennial.crypto_clean_architecture.domain.model.Coin
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_coin_list.*

@AndroidEntryPoint
class CoinListActivity : AppCompatActivity() {
    private val viewModel: CoinListViewModel by viewModels()

    private val coinList = mutableListOf<Coin>()
    private lateinit var coinListAdapter: CoinListAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)

        coinListAdapter = CoinListAdapter(coinList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = coinListAdapter

        viewModel.getCoinsLivedata().observe(this, Observer {
            coinList.addAll(it)
            coinListAdapter.notifyDataSetChanged()
        })
    }
}