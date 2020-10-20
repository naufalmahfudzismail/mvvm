package id.dev.test.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.dev.test.model.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    suspend fun getAll(): MutableList<Category>

    @Query("DELETE FROM Category")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg category: Category)
}