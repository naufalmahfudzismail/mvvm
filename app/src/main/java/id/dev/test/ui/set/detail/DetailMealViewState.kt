package id.dev.test.ui.set.detail

import id.dev.test.model.Category
import id.dev.test.model.Meal
import id.dev.test.model.MealDetail

class DetailMealViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<MealDetail>? = null
) {
}