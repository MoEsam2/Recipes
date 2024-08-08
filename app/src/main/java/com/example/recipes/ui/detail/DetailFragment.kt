package com.example.recipes.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipes.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = args.image
        val proteins = args.proteins
        val carbs = args.carbs
        val fats = args.fats

        loadImage(imageUrl, carbs, proteins, fats)
    }

    private fun loadImage(
        imageUrl: String,
        carbs: String,
        proteins: String,
        fats: String
    ) {
        Glide.with(requireContext())
            .load(imageUrl)
            .into(binding.imageRecipe)
        binding.apply {
            textCarbsValue.text = carbs
            textProteinValue.text = proteins
            textFatsValue.text = fats
        }
    }


}