package com.perennial.crypto_clean_architecture.presentation.coin_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perennial.crypto_clean_architecture.R
import com.perennial.crypto_clean_architecture.domain.model.Coin
import kotlinx.android.synthetic.main.coint_list_item.view.*

class CoinListAdapter(var coinList: List<Coin>) :
    RecyclerView.Adapter<CoinListAdapter.CoinListViewHolder>() {

    inner class CoinListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.coint_list_item, parent, false)
        return CoinListViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val currentCoin = coinList[position]

        holder.itemView.apply {
            text_rank.text = "${currentCoin.rank}."
            text_name.text = currentCoin.name
            text_symbol.text = "( ${currentCoin.symbol} )"
            if (currentCoin.is_active) {
                text_active.text = "active"
            }

        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}