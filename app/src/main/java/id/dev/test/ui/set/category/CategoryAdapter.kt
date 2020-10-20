package id.dev.test.ui.set.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.dev.test.R
import id.dev.test.model.Category
import kotlinx.android.synthetic.main.card_item_category.view.*
import java.util.*

class CategoryAdapter(val listener: (Category) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categories = mutableListOf<Category>()
    private var dataOriginal = mutableListOf<Category>()

    fun search(key: String) {
        val data = dataOriginal.filter {
            key.toLowerCase(Locale.ROOT)
                .let { query -> it.strCategory!!.toLowerCase(Locale.ROOT).contains(query) }
        }
        updateData(data as MutableList<Category>)
    }

    fun sortAscending() {
        val data = categories.sortedBy { it.strCategory }
        updateData(data as MutableList<Category>)
    }

    fun sortDescending() {
        val data = categories.sortedByDescending { it.strCategory }
        updateData(data as MutableList<Category>)
    }


    fun setOriginal(original: MutableList<Category>){
        dataOriginal = original
    }

    fun updateData(newData: MutableList<Category>) {
        categories = newData
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun binding(category: Category) {

            view.txt_category_description.text = category.strCategoryDescription
            view.txt_category_name.text = category.strCategory

            Glide.with(view).load(category.strCategoryThumb).into(view.img_category)


            view.setOnClickListener {
                listener(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_category, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.binding(categories[position])

    override fun getItemCount(): Int = categories.size
}