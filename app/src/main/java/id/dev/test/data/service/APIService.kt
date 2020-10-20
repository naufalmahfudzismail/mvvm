package id.dev.test.data.service

import id.dev.test.model.Category
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("categories.php")
    suspend fun getCategories(): Response<Category.CategoryResponse>

    @GET("filter.php")
    suspend fun getMealByCategory(@Query("c") category: String): Response<Meal.MealResponse>

    @GET("search.php")
    suspend fun getSearchMeal(@Query("s") key: String): Response<Meal.MealResponse>

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: Int): Response<MealDetail.MealDetailResponse>

}