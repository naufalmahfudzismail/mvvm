package id.dev.test.data.datastore.detail

import id.dev.test.data.service.APIService
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

class MealDetailRemoteDataStore(private val service : APIService) : MealDetailDataStore {
    override suspend fun getMeals(idMeal: Int): MutableList<MealDetail>? {
        val response = service.getMealDetail(idMeal)
        if(response.isSuccessful) return response.body()?.meals

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(idMeal: Int, meals: MutableList<MealDetail>?) {

    }
}