package id.dev.test.data.repository

import id.dev.test.base.BaseRepository
import id.dev.test.data.datastore.meal.MealDataStore
import id.dev.test.model.Meal

class MealsRepository private constructor() : BaseRepository<MealDataStore>() {

    suspend fun getSearchMeal(key : String): MutableList<Meal>? {
        val cache = localDataStore?.getSearchMeal(key)
        if (cache != null) return cache
        val response = remoteDataStore?.getSearchMeal(key)
        localDataStore?.addSearchAll(key, response)
        return response
    }

    suspend fun getMeals(categoryName: String): MutableList<Meal>? {
        val cache = localDataStore?.getMeals(categoryName)
        if (cache != null) return cache
        val response = remoteDataStore?.getMeals(categoryName)
        localDataStore?.addAll(categoryName, response)
        return response
    }

    companion object {
        val instance by lazy { MealsRepository() }
    }
}