package id.dev.test.data.datastore.detail

import id.dev.test.model.Category
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

interface MealDetailDataStore{
    suspend fun  getMeals(idMeal : Int) : MutableList<MealDetail>?
    suspend fun addAll(idMeal: Int, meals: MutableList<MealDetail>?)
}