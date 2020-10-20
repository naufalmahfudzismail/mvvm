package id.dev.test.data.datastore.meal

import id.dev.test.model.Meal

interface MealDataStore {
    suspend fun getMeals(categoryName: String): MutableList<Meal>?
    suspend fun getSearchMeal(key: String): MutableList<Meal>?
    suspend fun addAll(categoryName: String, meals: MutableList<Meal>?)
    suspend fun addSearchAll(key: String, meals: MutableList<Meal>?)
}