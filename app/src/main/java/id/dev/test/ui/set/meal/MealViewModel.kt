package id.dev.test.ui.set.meal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.dev.test.data.repository.MealsRepository
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealsRepository) : ViewModel() {

    val viewState = MutableLiveData<MealViewState>().apply {
        value = MealViewState(loading = true)
    }

    fun getMeals(categoryName: String) = viewModelScope.launch {
        try {
            val data = repository.getMeals(categoryName)
            viewState.value = MealViewState(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            viewState.value = MealViewState(loading = false, error = ex, data = null)
        }
    }

    fun getSearchMeals(key: String) = viewModelScope.launch {
        try {
            val data = repository.getSearchMeal(key)
            viewState.value = MealViewState(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            viewState.value = MealViewState(loading = false, error = ex, data = null)
        }
    }

}