package id.dev.test.ui.set.category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.dev.test.data.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    val viewState = MutableLiveData<CategoryViewState>().apply {
        value = CategoryViewState(loading = true)
    }

    init {
        getCategory()
    }

    fun getCategory() = viewModelScope.launch {
        try {
            val data = repository.getCategory()
            Log.e("data", data.toString())
            viewState.value = CategoryViewState(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            viewState.value = CategoryViewState(loading = false, error = ex, data = null)
        }
    }

}