package id.dev.test

import android.app.Application
import id.dev.test.data.database.MakanApaDatabase
import id.dev.test.data.datastore.category.CategoryRemoteDataStore
import id.dev.test.data.datastore.category.CategoryRoomDataStore
import id.dev.test.data.datastore.detail.MealDetailRemoteDataStore
import id.dev.test.data.datastore.detail.MealDetailRoomDataStore
import id.dev.test.data.datastore.meal.MealRemoteDataStore
import id.dev.test.data.datastore.meal.MealRoomDataStore
import id.dev.test.data.repository.CategoryRepository
import id.dev.test.data.repository.MealDetailRepository
import id.dev.test.data.repository.MealsRepository
import id.dev.test.data.service.APIRepository

class MakanApa : Application() {

    override fun onCreate() {
        super.onCreate()

        val service = APIRepository.API_SERVICE
        val database = MakanApaDatabase.getInstance(this)

        CategoryRepository.instance.apply {
            init(
                CategoryRoomDataStore(database.categoryDao()),
                CategoryRemoteDataStore(service)
            )
        }

        MealsRepository.instance.apply {
            init(
                MealRoomDataStore(database.mealDao()),
                MealRemoteDataStore(service)
            )
        }

        MealDetailRepository.instance.apply {
            init(
                MealDetailRoomDataStore(database.detailMealDao()),
                MealDetailRemoteDataStore(service)
            )
        }


    }
}