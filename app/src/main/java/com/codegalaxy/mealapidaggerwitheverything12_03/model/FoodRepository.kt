package com.codegalaxy.mealapidaggerwitheverything12_03.model

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(private val apiService: APIService) {
    suspend fun fetchAllCategory() : Response<FoodListResponse>{
        return apiService.getAllCategory()
    }
}