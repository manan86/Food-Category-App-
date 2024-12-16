package com.codegalaxy.mealapidaggerwitheverything12_03.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodEntity
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodRepository
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(private val repository: FoodRepository) : ViewModel(){

//    private val _category = MutableLiveData<List<FoodResponse>>()
//    val category: LiveData<List<FoodResponse>> = _category
    private val _category = MutableStateFlow<List<FoodResponse>>(emptyList())
    val category: StateFlow<List<FoodResponse>> = _category

    fun getCategoryFromViewModel() {
        viewModelScope.launch {
            try {
                val response = repository.fetchAllCategory()
                if (response.isSuccessful){
                    val categories = response.body()?.category ?: emptyList()
                    _category.emit(categories)

                    categories.forEach {
                        category ->
                        val foodEntity = FoodEntity(
                            category = category.category,
                            image = category.image,
                            desc = category.desc
                        )
                        repository.saveFoodRoom(foodEntity)
                    }
                }
                else{
                    println("Not able to find data ${response.message()}")
                }
            }catch (e : Exception){
                e.printStackTrace()
                print("Error : ${e.message}")
            }
        }
    }
}