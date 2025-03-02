package com.example.nasaexplorer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nasaexplorer.databinding.ActivityApodBinding
import com.example.nasaexplorer.viewmodel.ApodViewModel

class ApodActivity : AppCompatActivity() {
    private lateinit var apodViewModel: ApodViewModel
    private lateinit var binding: ActivityApodBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apodViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)
        apodViewModel.fetchApodData("4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf")
        apodViewModel.apodData.observe(this, Observer {
            apod ->
            var apdodImage = binding.apodImage;
            binding.apodTitle.text = apod.title
            Glide.with(this)
                .load(apod.url)
               .into(apdodImage)

            binding.apodExplanation.text = apod.explanation
        })

    }
}