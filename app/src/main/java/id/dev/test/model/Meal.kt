package id.dev.test.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Meal(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var categoryName: String?,
    @SerializedName("idMeal")
    var idMeal: Int, // 52959
    @SerializedName("strMeal")
    var strMeal: String? = null, // Baked salmon with fennel & tomatoes
    @SerializedName("strMealThumb")
    var strMealThumb: String? = null // https://www.themealdb.com/images/media/meals/1548772327.jpg
) : Parcelable {
    data class MealResponse(
        @SerializedName("meals")
        var meals: MutableList<Meal>? = null
    )
}