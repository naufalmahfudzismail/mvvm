package id.dev.test.ui.set.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.dev.test.R
import kotlinx.android.synthetic.main.item_text.view.*

class TextAdapter(val data : MutableList<String>) :
    RecyclerView.Adapter<TextAdapter.ViewHolder>() {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun binding(text : String) {
            view.txt_text.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.binding(data[position])

    override fun getItemCount(): Int = data.size
}