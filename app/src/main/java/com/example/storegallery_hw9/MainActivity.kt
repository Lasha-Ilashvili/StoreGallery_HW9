package com.example.storegallery_hw9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storegallery_hw9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val filters = mutableListOf<Filter>()

    private val storeItems = mutableListOf<StoreItem>()

    private var selectedFilter: Filter? = Filter(filterType = "All")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }

    private fun setUp() {
        setUpFilterRecycler()
        setUpFilters()

        setUpStoreItemRecycler()
        setUpStoreItems()
    }

    private fun setUpFilterRecycler() {
        binding.filterRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.filterRecyclerView.adapter = FilterRecyclerAdapter(filters) { clickedFilter ->
            if (selectedFilter == clickedFilter) {
                selectedFilter = Filter(filterType = "All")
            } else {
                selectedFilter = clickedFilter
            }

            val filteredItems = if (selectedFilter?.filterType != "All") {
                storeItems.filter { item -> selectedFilter!!.filterType == item.itemType }
            } else {
                storeItems
            }
            (binding.storeItemRecyclerView.adapter as? StoreItemRecyclerAdapter)?.updateItems(
                filteredItems
            )
        }
    }

    private fun setUpFilters() {
        filters.also {
            it.add(
                Filter(
                    filterEmoji = "",
                    filterType = "All"
                )
            )

            it.add(
                Filter(
                    filterEmoji = "🎉",
                    filterType = "Party"
                )
            )

            it.add(
                Filter(
                    filterEmoji = "\uD83C\uDFD5",
                    filterType = "Camping"
                )
            )

            it.add(
                Filter(
                    filterType = "Category1"
                )
            )

            it.add(
                Filter(
                    filterType = "Category2"
                )
            )

            it.add(
                Filter(
                    filterType = "Category3"
                )
            )
        }
    }

    private fun setUpStoreItemRecycler() {
        binding.storeItemRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.storeItemRecyclerView.adapter = StoreItemRecyclerAdapter(storeItems)
    }

    private fun setUpStoreItems() {
        storeItems.also {
            it.add(
                StoreItem(
                    itemModel = R.drawable.model4,
                    itemTitle = "The North face glacier",
                    itemPrice = "$650",
                    itemType = "Party"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model1,
                    itemTitle = "Belt suit blazer",
                    itemPrice = "$120",
                    itemType = "Category3"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model3,
                    itemTitle = "Belt suit blazer",
                    itemPrice = "$120",
                    itemType = "Party"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model2,
                    itemTitle = "Banana hoodie",
                    itemPrice = "$146",
                    itemType = "Category2"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model2,
                    itemTitle = "Banana hoodie",
                    itemPrice = "$99",
                    itemType = "Camping"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model3,
                    itemTitle = "The North face glacier",
                    itemPrice = "$240",
                    itemType = "Category1"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model4,
                    itemTitle = "The North face glacier",
                    itemPrice = "$180",
                    itemType = "Party"
                )
            )

            it.add(
                StoreItem(
                    itemModel = R.drawable.model1,
                    itemTitle = "Belt suit blazer",
                    itemPrice = "$145",
                    itemType = "Category1"
                )
            )
        }
    }
}