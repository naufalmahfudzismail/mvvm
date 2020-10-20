package id.dev.test.ui.set.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import id.dev.test.R
import id.dev.test.data.repository.MealsRepository
import id.dev.test.model.Meal
import kotlinx.android.synthetic.main.fragment_meals.*


class MealsFragment : Fragment() {

    private val args: MealsFragmentArgs by navArgs()

    private lateinit var viewModel: MealViewModel
    private lateinit var adapter: MealAdapter

    private var isSearch = false
    private var key = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_meals, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MealAdapter {
            val action = MealsFragmentDirections.actionMealsFragmentToDetailMealFragment(
                it.idMeal
            )
            view.findNavController().navigate(action)
        }

        rv_meals.layoutManager = GridLayoutManager(activity, 2)
        rv_meals.adapter = adapter

        val factory = MealFactory(MealsRepository.instance)
        viewModel = ViewModelProviders.of(this, factory).get(MealViewModel::class.java).apply {

            viewState.observe(viewLifecycleOwner, Observer(this@MealsFragment::handleState))
            if (viewState.value?.data == null) {
                getMeals(args.setCategory.toString())
            }

            txt_key.text = "Category : ${args.setCategory.toString()}"

            search_meal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean = false
                override fun onQueryTextChange(newText: String?): Boolean {
                    isSearch = true
                    key = newText.toString()
                    txt_key.text = "Searching :  $newText"
                    getSearchMeals(key)
                    return false
                }
            })

            refresh_meals.setOnRefreshListener {
                refresh_meals.isRefreshing = false
                if (isSearch) getSearchMeals(key)
                else getMeals(args.setCategory.toString())
            }
        }

    }

    private fun handleState(viewState: MealViewState) {
        viewState.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showError(error: Exception) {
        txt_error.text = error.message
        txt_error.visibility = View.VISIBLE
        rv_meals.visibility = View.GONE

        shimmer_meals.stopShimmer()
        shimmer_meals.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {
        if (loading) {
            shimmer_meals.visibility = View.VISIBLE
            shimmer_meals.startShimmer()
        } else {
            shimmer_meals.stopShimmer()
            shimmer_meals.visibility = View.GONE
        }
    }

    private fun showData(data: MutableList<Meal>) {
        adapter.updateData(data)
        txt_error.visibility = View.GONE
        rv_meals.visibility = View.VISIBLE

        shimmer_meals.stopShimmer()
        shimmer_meals.visibility = View.GONE
    }
}