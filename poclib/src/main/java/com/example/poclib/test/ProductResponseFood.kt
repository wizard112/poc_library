package com.example.poclib.test

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created on 21.11.17.
 */
class ProductResponseFood {

    @Expose
    @SerializedName("stores_tags")
    var storesTag : ArrayList<String>? = null
        private set

    @Expose
    @SerializedName("additives_n")
    var additivesN : Int? = null
        private set

    @Expose
    var labels : String? = null
        private set

    @Expose
    @SerializedName("codes_tags")
    var codesTags : ArrayList<String>? = null
        private set

    @Expose
    @SerializedName("new_additives_n")
    var newAdditivesN : Int? = null
        private set

    @Expose
    @SerializedName("emb_codes_orig")
    var embCodesOrig : String? = null
        private set

    @Expose
    @SerializedName("countries_debug_tags")
    var countriesDebugTags : ArrayList<String>? = null
        private set

    @Expose
    @SerializedName("nutrition_score_debug")
    var nutritionSCoreDebug: String? = null
        private set

    @Expose
    @SerializedName("fruits-vegetables-nuts_100g_estimate")
    var fruitsVegetablesNUts: String? = null
        private set

    @Expose
    @SerializedName("entry_dates_tags")
    var entryDatesTags : ArrayList<String>? = null
        private set

    @Expose
    @SerializedName("ingredients_text")
    var ingredientsText: String? = null
        private set

    @Expose
    @SerializedName("generic_name")
    var genericName: String? = null
        private set

    @Expose
    @SerializedName("image_nutrition_small_url")
    var imageNutritionSmallUrl: String? = null
        private set

    @Expose
    @SerializedName("origins_tags")
    var originsTags : ArrayList<String>? = null
        private set

    @Expose
    var ingredients : ArrayList<IngredientProduct>? = null
        private set

    @Expose
    @SerializedName("scan_n")
    var scanN: Int? = null
        private set

    @Expose
    @SerializedName("last_modified_by")
    var lastModifiedBy: String? = null
        private set

    @Expose
    @SerializedName("image_ingredients_thumb_url")
    var imageINgredientsThumbUrl: String? = null
        private set

    @Expose
    var languages: LanguagesProduct? = null
        private set

    @Expose
    @SerializedName("countries_hierarchy")
    var countriesHierarchy : ArrayList<String>? = null
        private set

    override fun toString(): String {
        return additivesN!!.toString().plus(" - ")
                .plus(labels).plus(" - ")
                .plus(codesTags).plus(" - ")
                .plus(originsTags).plus(" - ").plus(ingredients.toString())
                .plus(" - ").plus(languages.toString())
                .plus(" - ").plus(countriesHierarchy)
    }
}