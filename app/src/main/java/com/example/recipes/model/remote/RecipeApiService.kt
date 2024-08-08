package com.example.recipes.model.remote

import com.example.recipes.model.dataClass.Recipe
import retrofit2.http.GET

interface RecipeApiService {
    @GET(RetrofitModule.RECIPES_ENDPOINT)
    suspend fun getRecipes(): ArrayList<Recipe>
}
