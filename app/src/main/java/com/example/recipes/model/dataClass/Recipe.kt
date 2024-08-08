package com.example.recipes.model.dataClass

import com.google.gson.annotations.SerializedName


data class Recipe(
    @SerializedName("carbos") var carbos: String? = null,
    @SerializedName("fats") var fats: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("proteins") var proteins: String? = null,
    )
