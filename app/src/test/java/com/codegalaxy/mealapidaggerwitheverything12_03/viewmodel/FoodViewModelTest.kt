package com.codegalaxy.mealapidaggerwitheverything12_03.viewmodel


import app.cash.turbine.test
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import com.codegalaxy.mealapidaggerwitheverything12_03.model.FoodListResponse


@ExperimentalCoroutinesApi
class FoodViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val repository = mockk<FoodRepository>()
    private lateinit var viewModel: FoodViewModel

    @Before
    fun setUp() {
        viewModel = FoodViewModel(repository)
    }

//    @Test
//    fun `GIVEN successful response WHEN getCategoryFromViewModel invoked THEN category StateFlow is updated`() = runTest {
//        val mockResponse = Response.success(FoodListResponse(listOf(FoodItem("Pizza"), FoodItem("Burger"))))
//        coEvery { repository.fetchAllCategory() } returns mockResponse
//
//        viewModel.getCategoryFromViewModel()
//
//        val expectedList = listOf(FoodItem("Pizza"), FoodItem("Burger"))
//        viewModel.category.test {
//            assertEquals(expectedList, awaitItem())
//        }
//        coVerify { repository.fetchAllCategory() }
//    }

    @Test
    fun `GIVEN unsuccessful response WHEN getCategoryFromViewModel invoked THEN StateFlow remains empty`() = runTest {
        val mockResponse = Response.error<FoodListResponse>(404, "Not Found".toResponseBody())
        coEvery { repository.fetchAllCategory() } returns mockResponse

        viewModel.getCategoryFromViewModel()
        viewModel.category.test {
            assertEquals(emptyList<FoodItem>(), awaitItem())
        }
    }

    @Test
    fun `GIVEN exception WHEN getCategoryFromViewModel invoked THEN exception is printed and StateFlow remains empty`() = runTest {
        val exception = RuntimeException("Network Error")
        coEvery { repository.fetchAllCategory() } throws exception

        viewModel.getCategoryFromViewModel()

        viewModel.category.test {
            assertEquals(emptyList<FoodItem>(), awaitItem())
        }
        //Generic exception
        //empty response
    }


    @After
    fun tearDown() {

    }
}
