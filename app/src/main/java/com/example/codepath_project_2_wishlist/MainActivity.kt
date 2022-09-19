package com.example.codepath_project_2_wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codepath_project_2_wishlist.databinding.ActivityMainBinding
import java.lang.Exception

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), WishlistAdapter.OnItemClickListener {

    // Fetch the list of data
    private val items = ItemFetcher.getItems()
    // Create adapter passing in the list of data
    private val wishlistAdapter = WishlistAdapter(items, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // Lookup the RecyclerView in activity layout
        val itemRecyclerView = binding.itemRecyclerView
        // Create adapter passing in the list of data
        itemRecyclerView.adapter = wishlistAdapter
        // Set layout manager to position the items
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        // Leveraging ItemClickSupport decorator to handle clicks on items in our recyclerView

        binding.nameEditText.setOnClickListener{
            binding.nameEditText.selectAll()
        }
        binding.urlEditText.setOnClickListener{
            binding.urlEditText.selectAll()
        }
        binding.submitButton.setOnClickListener() {
            val inputName = binding.nameEditText.text.toString()
            val inputUrl = binding.urlEditText.text.toString()
            try {
                val inputPrice = binding.priceEditText.text.toString().toDouble()
                inputName.uppercase()
                "%.2f".format(inputPrice).toDouble()
                items.add(Item(inputName, inputPrice, inputUrl))
                wishlistAdapter.notifyDataSetChanged()
            } catch(e: Exception) {
                Toast.makeText(applicationContext, "Error: Price entered was not valid. Please enter a number.", Toast.LENGTH_SHORT).show()
                binding.priceEditText.text.clear()
            }
        }
        binding.submitButton.setOnLongClickListener {
            true
        }
    }

    override fun onItemClick(position: Int) {
        TODO("Future implementation of intents")
    }

    //Long click deletes wishlist entry at click position
    override fun onLongItemClick(position: Int) {
        items.removeAt(position)
        wishlistAdapter.notifyDataSetChanged()
    }
}