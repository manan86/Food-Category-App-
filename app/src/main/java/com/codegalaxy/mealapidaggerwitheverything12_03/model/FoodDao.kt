package com.codegalaxy.mealapidaggerwitheverything12_03.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeFood(food : FoodEntity)
}