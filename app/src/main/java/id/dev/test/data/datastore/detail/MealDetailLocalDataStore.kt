package id.dev.test.data.datastore.detail

import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

class MealDetailLocalDataStore : MealDetailDataStore {

    private val caches = mutableMapOf<Int, MutableList<MealDetail>?>()

    override suspend fun getMeals(idMeal: Int): MutableList<MealDetail>? =
        if (caches.contains(idMeal)) caches[idMeal] else null

    override suspend fun addAll(idMeal: Int, meals: MutableList<MealDetail>?) {
        caches[idMeal] = meals
    }
}