package com.example.nasaexplorer.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nasaexplorer.R
import com.example.nasaexplorer.databinding.FragmentHomeBinding
import com.example.nasaexplorer.viewmodel.ApodViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param12"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var apodViewModel: ApodViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        apodViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)
        apodViewModel.fetchApodData("4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf")
        apodViewModel.apodData.observe(viewLifecycleOwner){
            apod ->
            var apdodImage = binding.apodImage;
            binding.apodTitle.text = apod.title
            Glide.with(this)
                .load(apod.url)
                .into(apdodImage)

            binding.apodExplanation.text = apod.explanation
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}