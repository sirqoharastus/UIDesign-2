package com.example.week4task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator


class ProductFragment : Fragment() {
    // initializing variables
    private lateinit var viewPager: ViewPager2
    private lateinit var modelCardList: ArrayList<CardModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            //val something = it.getString("GOOD")
            // val another = it.getString("BETTER")


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_activity, container, false)
        viewPager = view.findViewById(R.id.viewPager2)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initializing an array list of model cards
        modelCardList = ArrayList()

        modelCardList.add(CardModelClass("Darot", "$ 23,145,456", R.color.black))
        modelCardList.add(CardModelClass("Abdulqohar", "$ 50,000,000.00", R.color.purple_500))
        modelCardList.add(
            CardModelClass(
                "Olalekan",
                "$ 25, 000,000.00",
                R.color.design_default_color_on_secondary
            )
        )
        modelCardList.add(CardModelClass("Dapo", "$ 25,000,000.00", R.color.yellow))
        modelCardList.add(CardModelClass("Usman", "$ 16,000,000.00", R.color.green))

        val myAdapter: CardAdapter = CardAdapter(modelCardList)


///  initializing viewpager adapter and setting viewpager padding
        viewPager.adapter = myAdapter
        viewPager.setPadding(150, 0, 150, 0)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        //setting viewpager transformation
        val viewPageTransformer = CompositePageTransformer()
        viewPageTransformer.addTransformer(MarginPageTransformer(10))
        viewPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(viewPageTransformer)


        // setting table layout parameters
        TabLayoutMediator(view.findViewById(R.id.indicator), viewPager) { tab, position ->
            tab.icon = resources.getDrawable(R.drawable.activeindicator)
        }.attach()
        var countDots = myAdapter.itemCount
        val dots = arrayOfNulls<ImageView>(countDots)
        for (i in 0 until countDots) {
            dots[i] = ImageView(requireContext())
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.activeindicator
                )
            )
        }
        // initializing recycler view and its apter and setting its orientation and padding
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            adapter = ShoppingCardAdapter(view.getContext(), ShoppingCardObject.getList())
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setPadding(250, 0, 250, 0)
            recyclerView.clipToPadding = false
            recyclerView.clipChildren = false
        }
    }


}