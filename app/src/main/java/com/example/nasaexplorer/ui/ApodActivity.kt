package com.example.nasaexplorer.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nasaexplorer.R
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
            // Bind the APOD data to the UI (e.g., ImageView, TextView)

            apod ->
            var apdodImage = binding.apodImage;
            binding.apodTitle.text = apod.title
            Glide.with(this)
                .load(apod.url)
               .into(apdodImage)

            binding.apodExplanation.text = apod.explanation
        })
//
//        apodViewModel.fetchApodData("YOUR_API_KEY")
//        apodViewModel.apodData.observe(this, { apod ->
//            // Set Title
//            apodTitle.text = apod.title
//
//            // Set Explanation
//            apodExplanation.text = apod.explanation
//
//            // Load Image using Glide
//            Glide.with(this)
//                .load(apod.url)
//                .into(apodImage)
//        })
    }
}