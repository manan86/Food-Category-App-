package com.codegalaxy.mealapidaggerwitheverything12_03.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Food_Table")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id : Int? = null,

    @ColumnInfo(name = "Category") val category : String,

    @ColumnInfo(name = "Image") val image : String,

    @ColumnInfo(name = "Description") val desc : String
)
