package com.example.codepath_project_2_wishlist

class ItemFetcher {
    companion object {
        private val name = listOf("Jack", "Sally")
        private const val price = 2.50
        private val url = listOf("https://www.WhoaItWorks.com", "https://www.amazon.com")

        fun getItems(): MutableList<Item> {
            val items : MutableList<Item> = ArrayList()
            for (i in name.indices) {
                val item = Item(name[i], price, url[i])
                items.add(item)
            }
            return items
        }

    }
}