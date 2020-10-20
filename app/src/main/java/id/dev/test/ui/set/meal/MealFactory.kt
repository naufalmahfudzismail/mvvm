package id.dev.test.ui.set.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.dev.test.data.repository.CategoryRepository
import id.dev.test.data.repository.MealsRepository

@Suppress("UNCHECKED_CAST")
class MealFactory(private val repository: MealsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealViewModel::class.java))
            return MealViewModel(repository) as T
        throw IllegalArgumentException()
    }
}