package id.dev.test.ui.set.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.dev.test.data.repository.MealDetailRepository
import id.dev.test.data.repository.MealsRepository

@Suppress("UNCHECKED_CAST")

class DetailMealFactory(private val repository: MealDetailRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailMealViewModel::class.java))
            return DetailMealViewModel(repository) as T
        throw IllegalArgumentException()
    }
}