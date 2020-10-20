package id.dev.test.data.datastore.detail

import id.dev.test.data.database.MealDao
import id.dev.test.data.database.MealDetailDao
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

class MealDetailRoomDataStore(private val mealDao: MealDetailDao) : MealDetailDataStore {
    override suspend fun getMeals(idMeal: Int): MutableList<MealDetail>? {
        val data = mealDao.getAll(idMeal)
        return if (data.isEmpty()) null else data
    }

    override suspend fun addAll(idMeal: Int, meals: MutableList<MealDetail>?) {
        meals.let {
            if (it != null) {
                mealDao.insertAll(*it.toTypedArray())
            }
        }
    }
}