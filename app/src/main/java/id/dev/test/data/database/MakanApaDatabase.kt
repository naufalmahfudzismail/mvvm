package id.dev.test.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.dev.test.model.Category
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail


@Database(
    entities = [Category::class, Meal::class, MealDetail::class],
    version = 1,
    exportSchema = false
)
abstract class MakanApaDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun mealDao(): MealDao
    abstract fun detailMealDao(): MealDetailDao

    companion object {
        private var instance: MakanApaDatabase? = null
        fun getInstance(context: Context): MakanApaDatabase {
            instance?.let { return it }
            instance = Room.databaseBuilder(
                context.applicationContext,
                MakanApaDatabase::class.java,
                "makan-apa"
            ).build()
            return instance!!
        }
    }
}