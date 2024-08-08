package com.example.recipes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.FragmentHomeBinding
import com.example.recipes.model.dataClass.Recipe
import com.example.recipes.viewModel.HomeFragmentViewModel


class HomeFragment : Fragment(), RecipeAdapter.RecipeInteractionListener {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.recipe.observe(viewLifecycleOwner) { recipes ->
            val adapter = RecipeAdapter(recipes, this)
            binding.recyclerViewRecipes.adapter = adapter
        }

        viewModel.getRecipe()

    }

    override fun onRecipeClick(recipe: Recipe) {
        val proteins = recipe.proteins ?: ""
        val carbs = recipe.carbos ?: ""
        val fats = recipe.fats ?: ""
        val image = recipe.image ?: ""
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(proteins, carbs, fats, image)
        findNavController().navigate(action)
    }

}