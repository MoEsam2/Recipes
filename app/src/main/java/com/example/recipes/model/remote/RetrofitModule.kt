package com.example.recipes.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    const val RECIPES_ENDPOINT = "android-test/recipes.json"
    private const val BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/"


    private val recipeRetrofitClient =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val recipeApiService: RecipeApiService =
        recipeRetrofitClient.create(RecipeApiService::class.java)
}
