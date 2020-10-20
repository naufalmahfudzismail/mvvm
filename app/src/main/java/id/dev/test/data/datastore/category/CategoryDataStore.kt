package id.dev.test.data.datastore.category

import id.dev.test.model.Category

interface CategoryDataStore {
    suspend fun  getCategories() : MutableList<Category>?
    suspend fun addAll(categories: MutableList<Category>?)
}