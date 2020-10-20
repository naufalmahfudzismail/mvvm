package id.dev.test.data.datastore.category

import id.dev.test.model.Category

class CategoryLocalDataStore : CategoryDataStore {

    private var caches = mutableListOf<Category>()

    override suspend fun getCategories(): MutableList<Category>? =
        if (caches.isNotEmpty()) caches else null

    override suspend fun addAll(categories: MutableList<Category>?) {
        categories.let {
            if (it != null) {
                caches = it
            }
        }
    }
}