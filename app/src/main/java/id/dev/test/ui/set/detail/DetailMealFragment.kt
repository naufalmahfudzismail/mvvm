package id.dev.test.ui.set.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.dev.test.R
import id.dev.test.data.repository.MealDetailRepository
import id.dev.test.model.MealDetail
import kotlinx.android.synthetic.main.fragment_detail_meal.*


class DetailMealFragment : Fragment() {

    val args: DetailMealFragmentArgs by navArgs()
    private val ingredients = mutableListOf<String>()
    private val measurements = mutableListOf<String>()

    private lateinit var viewModel: DetailMealViewModel
    private var details = mutableListOf<MealDetail>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail_meal, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = DetailMealFactory(MealDetailRepository.instance)

        viewModel =
            ViewModelProviders.of(this, factory).get(DetailMealViewModel::class.java).apply {
                viewState.observe(viewLifecycleOwner, this@DetailMealFragment::handleState)
                if (viewState.value?.data == null) {
                    getMeals(args.setId)
                }
            }
    }

    private fun handleState(viewState: DetailMealViewState) {
        viewState.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showError(error: Exception) {
        rl_error.visibility = View.VISIBLE
        ll_detail_content.visibility = View.GONE

        shimmer_detail.stopShimmer()
        shimmer_detail.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {
        if (loading) {
            shimmer_detail.visibility = View.VISIBLE
            ll_detail_content.visibility = View.GONE
            shimmer_detail.startShimmer()
        } else {
            shimmer_detail.stopShimmer()
            shimmer_detail.visibility = View.GONE
            ll_detail_content.visibility = View.VISIBLE
        }
    }

    private fun showData(data: MutableList<MealDetail>) {
        rl_error.visibility = View.GONE
        shimmer_detail.stopShimmer()
        shimmer_detail.visibility = View.GONE
        ll_detail_content.visibility = View.VISIBLE

        val detail = data[0]

        img_poster.let {
            Glide.with(this).load(detail.strMealThumb).into(it)
        }

        txt_title_meal.text = detail.strMeal
        txt_meal_category.text = detail.strCategory
        txt_meal_city.text = detail.strArea
        txt_meal_tag.text = detail.strTags
        txt_youtube.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(detail.strYoutube)
                )
            )
        }

        checkIngredientsData(detail.strIngredient1)
        checkIngredientsData(detail.strIngredient2)
        checkIngredientsData(detail.strIngredient3)
        checkIngredientsData(detail.strIngredient4)
        checkIngredientsData(detail.strIngredient5)
        checkIngredientsData(detail.strIngredient6)
        checkIngredientsData(detail.strIngredient7)
        checkIngredientsData(detail.strIngredient8)
        checkIngredientsData(detail.strIngredient9)
        checkIngredientsData(detail.strIngredient10)
        checkIngredientsData(detail.strIngredient11)
        checkIngredientsData(detail.strIngredient12)
        checkIngredientsData(detail.strIngredient13)
        checkIngredientsData(detail.strIngredient14)
        checkIngredientsData(detail.strIngredient15)
        checkIngredientsData(detail.strIngredient16)
        checkIngredientsData(detail.strIngredient17)
        checkIngredientsData(detail.strIngredient18)
        checkIngredientsData(detail.strIngredient19)
        checkIngredientsData(detail.strIngredient20)

        checkMeasurementData(detail.strMeasure1)
        checkMeasurementData(detail.strMeasure2)
        checkMeasurementData(detail.strMeasure3)
        checkMeasurementData(detail.strMeasure4)
        checkMeasurementData(detail.strMeasure5)
        checkMeasurementData(detail.strMeasure6)
        checkMeasurementData(detail.strMeasure7)
        checkMeasurementData(detail.strMeasure8)
        checkMeasurementData(detail.strMeasure9)
        checkMeasurementData(detail.strMeasure10)
        checkMeasurementData(detail.strMeasure11)
        checkMeasurementData(detail.strMeasure12)
        checkMeasurementData(detail.strMeasure13)
        checkMeasurementData(detail.strMeasure14)
        checkMeasurementData(detail.strMeasure15)
        checkMeasurementData(detail.strMeasure16)
        checkMeasurementData(detail.strMeasure17)
        checkMeasurementData(detail.strMeasure18)
        checkMeasurementData(detail.strMeasure19)
        checkMeasurementData(detail.strMeasure20)


        Log.e("data", ingredients.toString())

        val ingredientAdapter = TextAdapter(ingredients)
        val measureAdapter = TextAdapter(measurements)


        ingredient_list.layoutManager = LinearLayoutManager(activity)
        measure_list.layoutManager = LinearLayoutManager(activity)
        ingredient_list.adapter = ingredientAdapter
        measure_list.adapter = measureAdapter

        txt_procedure.text = detail.strInstructions

        txt_source.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(detail.strSource)
                )
            )
        }

    }


    private fun checkIngredientsData(string: String?) {
        if (!string.isNullOrBlank()) {
            ingredients.add(string)
        }
    }

    private fun checkMeasurementData(string: String?) {
        if (!string.isNullOrBlank()) {
            measurements.add(string)
        }
    }
}