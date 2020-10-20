package id.dev.test.ui.set.meal

import id.dev.test.model.Category
import id.dev.test.model.Meal

class MealViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<Meal>? = null
) {
}