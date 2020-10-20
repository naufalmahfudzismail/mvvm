package id.dev.test.ui.set.category

import id.dev.test.model.Category

class CategoryViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<Category>? = null
) {
}