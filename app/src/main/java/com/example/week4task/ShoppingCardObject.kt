package com.example.week4task

object ShoppingCardObject {

    private val list: ArrayList<ShoppingCardModelClass> = ArrayList()

    init {
        list.apply {
            add(
                ShoppingCardModelClass(
                    "AliExpress",
                    "from 4%",
                    "Shoes and bags",
                    R.drawable.shopping_bag_1
                )
            )
            add(
                ShoppingCardModelClass(
                    "Aviasales",
                    "from 4.4%",
                    "Tickets and Travels",
                    R.drawable.shopping_bag_1_2
                )
            )
            add(ShoppingCardModelClass("AliExpress", "4%", "Lingerie", R.drawable.shopping_bag_1))
            add(
                ShoppingCardModelClass(
                    "Jumia",
                    "from 13%",
                    "Phones and Laptop",
                    R.drawable.shopping_bag_1_2
                )
            )
        }


    }

    fun getList(): ArrayList<ShoppingCardModelClass> {
        return list
    }

}