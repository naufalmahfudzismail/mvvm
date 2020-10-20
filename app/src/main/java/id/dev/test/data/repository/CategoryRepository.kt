package id.dev.test.data.repository

import id.dev.test.base.BaseRepository
import id.dev.test.data.datastore.category.CategoryDataStore
import id.dev.test.model.Category

class CategoryRepository private constructor() : BaseRepository<CategoryDataStore>() {

    suspend fun getCategory(): MutableList<Category>? {
        val cache = localDataStore?.getCategories()
        if (cache != null) return cache
        val response = remoteDataStore?.getCategories()
        localDataStore?.addAll(response)
        return response
    }

    companion object {
        val instance by lazy { CategoryRepository() }
    }
}