package com.example.nasaexplorer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaexplorer.R
import com.example.nasaexplorer.databinding.FragmentNewsBinding
import com.example.nasaexplorer.ui.adapters.NEOAdapter
import com.example.nasaexplorer.viewmodel.NEOViewModel

class News : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var neoViewModel: NEOViewModel
    private lateinit var adapter: NEOAdapter

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
        adapter = NEOAdapter(emptyList())
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNews.adapter = adapter
        // Fetch NEO data
        neoViewModel.fetchNEOData("4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf") // Replace with your API key

        // Observe NEO data
        neoViewModel.neoData.observe(viewLifecycleOwner) { neoList ->
            adapter.updateData(neoList)
        }
    }
}