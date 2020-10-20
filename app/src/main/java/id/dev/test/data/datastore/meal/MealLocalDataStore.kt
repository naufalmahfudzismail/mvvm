package id.dev.test.data.datastore.meal

import id.dev.test.model.Meal

class MealLocalDataStore : MealDataStore {

    private val caches = mutableMapOf<String, MutableList<Meal>?>()

    override suspend fun getMeals(categoryName: String): MutableList<Meal>? =
        if (caches.contains(categoryName)) caches[categoryName] else null

    override suspend fun getSearchMeal(key: String): MutableList<Meal>? =
        if (caches.contains(key)) caches[key] else null


    override suspend fun addAll(categoryName: String, meals: MutableList<Meal>?) {
        caches[categoryName] = meals
    }

    override suspend fun addSearchAll(key: String, meals: MutableList<Meal>?) {
        caches[key] = meals
    }
}