package id.dev.test.ui.set.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import id.dev.test.R
import id.dev.test.data.repository.CategoryRepository
import id.dev.test.model.Category
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoryFragment : Fragment() {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter

    private var isAscending = true
    private var isRefreshing = true


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_categories, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CategoryAdapter {
            val action =
                CategoryFragmentDirections.actionCategoriesFragmentToMealsFragment(it.strCategory)
            view.findNavController().navigate(action)
        }

        rv_category.layoutManager = GridLayoutManager(activity, 2)
        rv_category.adapter = adapter

        val factory = CategoryFactory(CategoryRepository.instance)
        viewModel = ViewModelProviders.of(this, factory).get(CategoryViewModel::class.java).apply {
            viewState.observe(viewLifecycleOwner, Observer(this@CategoryFragment::handleState))
            refresh_category.setOnRefreshListener {
                refresh_category.isRefreshing = false
                getCategory()
            }
        }

        search_category.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.search(newText.toString())
                return false
            }
        })

        btn_sort.setOnClickListener {
            isAscending = if (!isAscending) {
                btn_sort.text = "Z -> A"
                adapter.sortAscending()
                true
            } else {
                btn_sort.text = "A -> Z"
                adapter.sortDescending()
                false
            }
        }
    }

    private fun handleState(viewState: CategoryViewState) {
        viewState.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showError(error: Exception) {
        txt_error.text = error.message
        txt_error.visibility = View.VISIBLE
        rv_category.visibility = View.GONE

        shimmer_category.stopShimmer()
        shimmer_category.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {

        if (loading) {
            shimmer_category.visibility = View.VISIBLE
            shimmer_category.startShimmer()
        } else {
            shimmer_category.stopShimmer()
            shimmer_category.visibility = View.GONE
        }
    }

    private fun showData(data: MutableList<Category>) {
        adapter.updateData(data)
        adapter.setOriginal(data)
        txt_error.visibility = View.GONE
        rv_category.visibility = View.VISIBLE

        shimmer_category.stopShimmer()
        shimmer_category.visibility = View.GONE

    }

}