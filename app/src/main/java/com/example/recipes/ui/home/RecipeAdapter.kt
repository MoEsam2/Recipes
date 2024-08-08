package com.example.recipes.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipes.databinding.RecipeViewItemBinding
import com.example.recipes.model.dataClass.Recipe

class RecipeAdapter(
    private val recipes: ArrayList<Recipe>,
    private val listener: RecipeInteractionListener
) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(private val binding: RecipeViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe, listener: RecipeInteractionListener) {
            binding.textRecipeName.text = recipe.name
            Glide.with(binding.imageRecipe.context)
                .load(recipe.image)
                .into(binding.imageRecipe)

            binding.root.setOnClickListener {
                listener.onRecipeClick(recipe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            RecipeViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe, listener)
    }

    interface RecipeInteractionListener {
        fun onRecipeClick(recipe: Recipe)
    }

}