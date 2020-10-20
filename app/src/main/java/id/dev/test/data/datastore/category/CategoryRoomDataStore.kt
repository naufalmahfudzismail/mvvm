package id.dev.test.data.datastore.category

import id.dev.test.data.database.CategoryDao
import id.dev.test.model.Category

class CategoryRoomDataStore(private val categoryDao: CategoryDao) : CategoryDataStore {
    override suspend fun getCategories(): MutableList<Category>? {
        val data = categoryDao.getAll()
        return if (data.isEmpty()) null else data
    }

    override suspend fun addAll(categories: MutableList<Category>?) {
        categories.let {
            categoryDao.insertAll()
        }
    }
}