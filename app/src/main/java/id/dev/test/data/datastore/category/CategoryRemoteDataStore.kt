package id.dev.test.data.datastore.category

import id.dev.test.data.service.APIService
import id.dev.test.model.Category

class CategoryRemoteDataStore(private val service: APIService) : CategoryDataStore {
    override suspend fun getCategories(): MutableList<Category>? {
        val response = service.getCategories()
        if (response.isSuccessful) return response.body()?.meals
        throw Exception("Terjadi kesalahan, status error ${response.code()}")
    }

    override suspend fun addAll(categories: MutableList<Category>?) {

    }

}