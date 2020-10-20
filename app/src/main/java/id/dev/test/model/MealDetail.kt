package id.dev.test.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MealDetail(
    @SerializedName("dateModified")
    var dateModified: String? = null, // null
    @SerializedName("idMeal")
    @PrimaryKey var idMeal: Int, // 52772
    @SerializedName("strArea")
    var strArea: String? = null, // Japanese
    @SerializedName("strCategory")
    var strCategory: String? = null, // Chicken
    @SerializedName("strDrinkAlternate")
    var strDrinkAlternate: String? = null, // null
    @SerializedName("strIngredient1")
    var strIngredient1: String? = null, // soy sauce
    @SerializedName("strIngredient10")
    var strIngredient10: String? = null,
    @SerializedName("strIngredient11")
    var strIngredient11: String? = null,
    @SerializedName("strIngredient12")
    var strIngredient12: String? = null,
    @SerializedName("strIngredient13")
    var strIngredient13: String? = null,
    @SerializedName("strIngredient14")
    var strIngredient14: String? = null,
    @SerializedName("strIngredient15")
    var strIngredient15: String? = null,
    @SerializedName("strIngredient16")
    var strIngredient16: String? = null, // null
    @SerializedName("strIngredient17")
    var strIngredient17: String? = null, // null
    @SerializedName("strIngredient18")
    var strIngredient18: String? = null, // null
    @SerializedName("strIngredient19")
    var strIngredient19: String? = null, // null
    @SerializedName("strIngredient2")
    var strIngredient2: String? = null, // water
    @SerializedName("strIngredient20")
    var strIngredient20: String? = null, // null
    @SerializedName("strIngredient3")
    var strIngredient3: String? = null, // brown sugar
    @SerializedName("strIngredient4")
    var strIngredient4: String? = null, // ground ginger
    @SerializedName("strIngredient5")
    var strIngredient5: String? = null, // minced garlic
    @SerializedName("strIngredient6")
    var strIngredient6: String? = null, // cornstarch
    @SerializedName("strIngredient7")
    var strIngredient7: String? = null, // chicken breasts
    @SerializedName("strIngredient8")
    var strIngredient8: String? = null, // stir-fry vegetables
    @SerializedName("strIngredient9")
    var strIngredient9: String? = null, // brown rice
    @SerializedName("strInstructions")
    var strInstructions: String? = null, // Preheat oven to 350° F. Spray a 9x13-inch baking pan with non-stick spray.Combine soy sauce, ½ cup water, brown sugar, ginger and garlic in a small saucepan and cover. Bring to a boil over medium heat. Remove lid and cook for one minute once boiling.Meanwhile, stir together the corn starch and 2 tablespoons of water in a separate dish until smooth. Once sauce is boiling, add mixture to the saucepan and stir to combine. Cook until the sauce starts to thicken then remove from heat.Place the chicken breasts in the prepared pan. Pour one cup of the sauce over top of chicken. Place chicken in oven and bake 35 minutes or until cooked through. Remove from oven and shred chicken in the dish using two forks.*Meanwhile, steam or cook the vegetables according to package directions.Add the cooked vegetables and rice to the casserole dish with the chicken. Add most of the remaining sauce, reserving a bit to drizzle over the top when serving. Gently toss everything together in the casserole dish until combined. Return to oven and cook 15 minutes. Remove from oven and let stand 5 minutes before serving. Drizzle each serving with remaining sauce. Enjoy!
    @SerializedName("strMeal")
    var strMeal: String? = null, // Teriyaki Chicken Casserole
    @SerializedName("strMealThumb")
    var strMealThumb: String? = null, // https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg
    @SerializedName("strMeasure1")
    var strMeasure1: String? = null, // 3/4 cup
    @SerializedName("strMeasure10")
    var strMeasure10: String? = null,
    @SerializedName("strMeasure11")
    var strMeasure11: String? = null,
    @SerializedName("strMeasure12")
    var strMeasure12: String? = null,
    @SerializedName("strMeasure13")
    var strMeasure13: String? = null,
    @SerializedName("strMeasure14")
    var strMeasure14: String? = null,
    @SerializedName("strMeasure15")
    var strMeasure15: String? = null,
    @SerializedName("strMeasure16")
    var strMeasure16: String? = null, // null
    @SerializedName("strMeasure17")
    var strMeasure17: String? = null, // null
    @SerializedName("strMeasure18")
    var strMeasure18: String? = null, // null
    @SerializedName("strMeasure19")
    var strMeasure19: String? = null, // null
    @SerializedName("strMeasure2")
    var strMeasure2: String? = null, // 1/2 cup
    @SerializedName("strMeasure20")
    var strMeasure20: String? = null, // null
    @SerializedName("strMeasure3")
    var strMeasure3: String? = null, // 1/4 cup
    @SerializedName("strMeasure4")
    var strMeasure4: String? = null, // 1/2 teaspoon
    @SerializedName("strMeasure5")
    var strMeasure5: String? = null, // 1/2 teaspoon
    @SerializedName("strMeasure6")
    var strMeasure6: String? = null, // 4 Tablespoons
    @SerializedName("strMeasure7")
    var strMeasure7: String? = null, // 2
    @SerializedName("strMeasure8")
    var strMeasure8: String? = null, // 1 (12 oz.)
    @SerializedName("strMeasure9")
    var strMeasure9: String? = null, // 3 cups
    @SerializedName("strSource")
    var strSource: String? = null, // null
    @SerializedName("strTags")
    var strTags: String? = null, // Meat,Casserole
    @SerializedName("strYoutube")
    var strYoutube: String? = null // https://www.youtube.com/watch?v=4aZr5hZXP_s
) : Parcelable {
    data class MealDetailResponse(
        @SerializedName("meals")
        var meals: MutableList<MealDetail>? = null
    )
}