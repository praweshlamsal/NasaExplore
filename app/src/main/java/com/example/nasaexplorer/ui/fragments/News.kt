package com.example.nasaexplorer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasaexplorer.R
import com.example.nasaexplorer.databinding.FragmentNewsBinding
import com.example.nasaexplorer.viewmodel.NEOViewModel

class News : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var neoViewModel: NEOViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using ViewBinding
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        neoViewModel = ViewModelProvider(this).get(NEOViewModel::class.java)

        // Fetch NEO data
        neoViewModel.fetchNEOData("4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf") // Replace with your API key

        // Observe NEO data
        neoViewModel.neoData.observe(viewLifecycleOwner) { neoList ->
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
        }
    }
}