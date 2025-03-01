package com.example.nasaexplorer.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nasaexplorer.R
import com.example.nasaexplorer.databinding.ActivityNeoBinding
import com.example.nasaexplorer.viewmodel.NEOViewModel

class NEOActivity : AppCompatActivity() {

    private lateinit var neoViewModel: NEOViewModel
    private lateinit var binding: ActivityNeoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Initialize ViewBinding
        binding = ActivityNeoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize ViewModel
        neoViewModel = ViewModelProvider(this).get(NEOViewModel::class.java)

        // Fetch NEO data
        neoViewModel.fetchNEOData("4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf")

        // Observe NEO data
        neoViewModel.neoData.observe(this, Observer { neoList ->
            if (neoList.isNotEmpty()) {
                // Display the first NEO object (for simplicity)
                val neo = neoList[0]
                binding.neoName.text = "Name: ${neo.name}"
                binding.neoDiameter.text = "Diameter: ${neo.estimated_diameter.kilometers.estimated_diameter_min} - ${neo.estimated_diameter.kilometers.estimated_diameter_max} km"
                binding.neoHazardous.text = "Hazardous: ${neo.is_potentially_hazardous_asteroid}"
                binding.neoApproachDate.text = "Approach Date: ${neo.close_approach_data[0].close_approach_date}"
            } else {
                // Show a message if no data is available
                binding.neoName.text = "No NEO data available."
            }
        })
    }
}