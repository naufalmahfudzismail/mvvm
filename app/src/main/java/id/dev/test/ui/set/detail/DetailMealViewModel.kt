package id.dev.test.ui.set.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.dev.test.data.repository.MealDetailRepository
import id.dev.test.data.repository.MealsRepository
import kotlinx.coroutines.launch

class DetailMealViewModel(private val repository: MealDetailRepository) : ViewModel() {

    val viewState = MutableLiveData<DetailMealViewState>().apply {
        value = DetailMealViewState(loading = true)
    }

    fun getMeals(id : Int) = viewModelScope.launch {
        try {
            val data = repository.getMeals(id)
            viewState.value = DetailMealViewState(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            viewState.value = DetailMealViewState(loading = false, error = ex, data = null)
        }
    }


}