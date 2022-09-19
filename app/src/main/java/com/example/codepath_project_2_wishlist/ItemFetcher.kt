package com.example.codepath_project_2_wishlist

class ItemFetcher {
    companion object {
        private val name = listOf("Jack", "Sally")
        private const val price = 2.50
        private const val url = "www.WhoaItWorks.com"

        fun getItems(): MutableList<Item> {
            val items : MutableList<Item> = ArrayList()
            for (i in name.indices) {
                val item = Item(name[i], price, url)
                items.add(item)
            }
            return items
        }

    }
}