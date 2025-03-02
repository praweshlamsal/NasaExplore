package com.example.nasaexplorer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasaexplorer.R
import com.example.nasaexplorer.databinding.FragmentImagesBinding
import com.example.nasaexplorer.ui.adapters.MarsPhotosAdapter
import com.example.nasaexplorer.viewmodel.MarsPhotosViewModel

private const val ARG_PARAM1 = "param12"
private const val ARG_PARAM2 = "param2"

class Images : Fragment() {

    private lateinit var binding: FragmentImagesBinding
    private lateinit var viewModel: MarsPhotosViewModel
    private lateinit var adapter: MarsPhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImagesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(MarsPhotosViewModel::class.java)

        // Setup RecyclerView
        adapter = MarsPhotosAdapter(emptyList())
        binding.marsPhotosRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.marsPhotosRecyclerView.adapter = adapter

        // Observe Mars Photos data
        viewModel.marsPhotos.observe(viewLifecycleOwner) { photos ->
            adapter = MarsPhotosAdapter(photos)
            binding.marsPhotosRecyclerView.adapter = adapter
        }

        // Fetch Mars Rover photos
        viewModel.fetchMarsPhotos("1000", "4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Images.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Images().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}