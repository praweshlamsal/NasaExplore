package com.example.nasaexplorer.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaexplorer.R
import com.example.nasaexplorer.ui.adapters.MarsPhotosAdapter
import com.example.nasaexplorer.viewmodel.MarsPhotosViewModel

class MarsPhotosActivity : AppCompatActivity() {
    private lateinit var viewModel: MarsPhotosViewModel
    private lateinit var adapter: MarsPhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_photos)

        viewModel = ViewModelProvider(this).get(MarsPhotosViewModel::class.java)
        adapter = MarsPhotosAdapter(emptyList())

        val recyclerView = findViewById<RecyclerView>(R.id.marsPhotosRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        viewModel.marsPhotos.observe(this, Observer { photos ->
            adapter = MarsPhotosAdapter(photos)
            recyclerView.adapter = adapter
        })

        // Fetch Mars Rover photos for a specific Earth date
        viewModel.fetchMarsPhotos("2023-10-01", "B4WOrKBWQqMfMn5t1EGPf7qzsAvNn5u14g1zmN8Lf")
    }
}