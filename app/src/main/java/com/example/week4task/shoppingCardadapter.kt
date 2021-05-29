package com.example.week4task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingCardAdapter(private var context: Context,private var viewHolderList:ArrayList<ShoppingCardModelClass>) : RecyclerView.Adapter<ShoppingCardAdapter.ViewHolder>(){


    class ViewHolder (view: View):RecyclerView.ViewHolder(view){

        //initializing variables
        val company: TextView
        val amount : TextView
        val commodities : TextView
        val shoppingBagImage: ImageView


        init {
            company = view.findViewById(R.id.company)
            amount = view.findViewById(R.id.percent)
            commodities = view.findViewById(R.id.commodity)
            shoppingBagImage = view.findViewById(R.id.shoppingBag)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.partners,parent,false))
    }


    override fun getItemCount(): Int {
       return viewHolderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView:ShoppingCardModelClass = viewHolderList.get(position)
        holder.apply {
            company.setText(cardView.company)
            amount.setText(cardView.percent)
            commodities.setText(cardView.commodity)
            shoppingBagImage.setImageResource(cardView.shopBag)
        }
    }

}


//}