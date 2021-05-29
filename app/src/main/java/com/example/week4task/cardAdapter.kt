package com.example.week4task

import android.content.res.ColorStateList
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val cardModelList: ArrayList<CardModelClass>) :
    RecyclerView.Adapter<CardAdapter.ViewPagerHolder>() {

    class ViewPagerHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)

        return ViewPagerHolder(view)
    }

    override fun getItemCount() = cardModelList.size

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {

        holder.itemView.apply {
            val nameText: TextView = findViewById(R.id.nameTextView)
            val accountBalanceText: TextView = findViewById(R.id.account_balance_textView)
            val cards = findViewById<CardView>(R.id.cards)

            nameText.text = cardModelList[position].name
            accountBalanceText.text = cardModelList[position].acctBalance

            cards.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    this.context,
                    cardModelList[position].color
                )
            )
        }
    }

}