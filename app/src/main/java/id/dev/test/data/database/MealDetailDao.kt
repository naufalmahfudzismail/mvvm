package id.dev.test.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

@Dao
interface MealDetailDao {
    @Query("SELECT * FROM MealDetail WHERE idMeal = :id ")
    suspend fun getAll(id: Int): MutableList<MealDetail>

    @Query("DELETE FROM MealDetail")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg meal: MealDetail)
}