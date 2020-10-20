package id.dev.test.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.dev.test.model.Category
import id.dev.test.model.Meal

@Dao
interface MealDao {
    @Query("SELECT * FROM Meal WHERE categoryName = :categoryName ")
    suspend fun getAll(categoryName : String): MutableList<Meal>

    @Query("SELECT * FROM Meal WHERE strMeal LIKE '%' || :name || '%' ")
    suspend fun getSearch(name : String): MutableList<Meal>

    @Query("DELETE FROM Meal")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg meal: Meal)
}