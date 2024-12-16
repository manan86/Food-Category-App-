package com.codegalaxy.mealapidaggerwitheverything12_03.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FoodEntity::class], version = 1)
abstract class FoodDatabase : RoomDatabase(){
    abstract fun foodDao() : FoodDao
}