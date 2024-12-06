package com.codegalaxy.mealapidaggerwitheverything12_03.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codegalaxy.mealapidaggerwitheverything12_03.databinding.ActivityMainBinding
import com.codegalaxy.mealapidaggerwitheverything12_03.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = FoodAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        viewModel.getCategoryFromViewModel()
        dataObserve()
    }

    private fun dataObserve() {

        //For Live Data we dont need any coroutine scope bcoz it is lifecycle aware
//        viewModel.category.observe{
//                data ->
//            val adapter = FoodAdapter(data)
//            binding.recyclerView.adapter = adapter
//        }
        lifecycleScope.launch {
            viewModel.category.collect{
                    data ->
                val adapter = FoodAdapter(data)
                binding.recyclerView.adapter = adapter
            }
        }
    }
}



