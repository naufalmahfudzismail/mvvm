package id.dev.test.ui.set.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.dev.test.R
import id.dev.test.model.Meal
import kotlinx.android.synthetic.main.card_item_meal.view.*

class MealAdapter(val listener: (Meal) -> Unit) :
    RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    private val meals = mutableListOf<Meal>()

    fun updateData(newData: MutableList<Meal>) {
        meals.clear()
        meals.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun binding(meal: Meal) {
            view.txt_meal_name.text = meal.strMeal
            view.txt_meal_description.text = meal.categoryName

            view.img_meal.let {
                Glide.with(view).load(meal.strMealThumb).into(it)
            }

            view.setOnClickListener {
                listener(meal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_meal, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.binding(meals[position])

    override fun getItemCount(): Int = meals.size
}