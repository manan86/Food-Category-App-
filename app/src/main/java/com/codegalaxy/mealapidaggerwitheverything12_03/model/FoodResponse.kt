package com.codegalaxy.mealapidaggerwitheverything12_03.model

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("idCategory")
    val id : String,

    @SerializedName("strCategory")
    val category : String,

    @SerializedName("strCategoryThumb")
    val image : String,

    @SerializedName("strCategoryDescription")
    val desc : String
)

data class FoodListResponse(
    @SerializedName("categories")
    val category : List<FoodResponse>
)
