package com.example.recipes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.model.dataClass.Recipe
import com.example.recipes.model.remote.RetrofitModule

import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {

    private val recipeApiService = RetrofitModule.recipeApiService
    private val _recipes = MutableLiveData<ArrayList<Recipe>>()
    val recipe: LiveData<ArrayList<Recipe>>
        get() = _recipes

    fun getRecipe() {
        viewModelScope.launch {
            val recipe = recipeApiService.getRecipes()
            _recipes.postValue(recipe)
        }
    }
}