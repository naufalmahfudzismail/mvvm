package id.dev.test.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Category(
    @PrimaryKey var idCategory: String,
    @SerializedName("strCategory")
    var strCategory: String? = null, // Beef
    @SerializedName("strCategoryThumb")
    var strCategoryThumb: String? = null, // Beef
    @SerializedName("strCategoryDescription")
    var strCategoryDescription: String? = null
) : Parcelable {
    data class CategoryResponse(
        @SerializedName("categories")
        var meals: MutableList<Category>? = null

    )
}