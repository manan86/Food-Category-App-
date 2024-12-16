package com.codegalaxy.mealapidaggerwitheverything12_03.model

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(private val apiService: APIService,
    private val dao: FoodDao
    ) {
    suspend fun fetchAllCategory() : Response<FoodListResponse>{
        return apiService.getAllCategory()
    }

    suspend fun saveFoodRoom(foodEntity: FoodEntity){
        return dao.storeFood(foodEntity)
    }
}