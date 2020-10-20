package id.dev.test.data.datastore.meal

import id.dev.test.data.service.APIService
import id.dev.test.model.Meal
import kotlinx.coroutines.GlobalScope

class MealRemoteDataStore(private val service : APIService) : MealDataStore {

    override suspend fun getMeals(categoryName: String): MutableList<Meal>? {
        val response = service.getMealByCategory(categoryName)
        if(response.isSuccessful) return response.body()?.meals

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getSearchMeal(key: String): MutableList<Meal>? {
        val response = service.getSearchMeal(key)
        if(response.isSuccessful) return response.body()?.meals

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(categoryName: String, meals: MutableList<Meal>?) {

    }

    override suspend fun addSearchAll(key: String, meals: MutableList<Meal>?) {

    }
}