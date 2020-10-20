package id.dev.test.data.datastore.meal

import id.dev.test.data.database.MealDao
import id.dev.test.model.Meal

class MealRoomDataStore(private val mealDao: MealDao) : MealDataStore {
    override suspend fun getMeals(categoryName: String): MutableList<Meal>? {
        val data = mealDao.getAll(categoryName)
        return if (data.isEmpty()) null else data
    }

    override suspend fun getSearchMeal(key: String): MutableList<Meal>? {
        val data = mealDao.getSearch(key)
        return if (data.isEmpty()) null else data
    }

    override suspend fun addAll(categoryName: String, meals: MutableList<Meal>?) {
        meals.let {
            if (it != null) {
                mealDao.insertAll(*it.toTypedArray())
            }
        }
    }

    override suspend fun addSearchAll(key: String, meals: MutableList<Meal>?) {
        meals.let {
            if (it != null) {
                mealDao.insertAll(*it.toTypedArray())
            }
        }
    }
}