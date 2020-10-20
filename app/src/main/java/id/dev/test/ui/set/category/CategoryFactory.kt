package id.dev.test.ui.set.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.dev.test.data.repository.CategoryRepository

@Suppress("UNCHECKED_CAST")
class CategoryFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java))
            return CategoryViewModel(repository) as T
        throw IllegalArgumentException()
    }
}