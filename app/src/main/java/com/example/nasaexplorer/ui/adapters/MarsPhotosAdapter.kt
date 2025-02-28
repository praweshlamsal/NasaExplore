package com.example.nasaexplorer.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaexplorer.data.models.Photo

class MarsPhotosAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<MarsPhotosAdapter.MarsPhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        // Inflate item layout
        return TODO("Provide the return value")
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        // Bind data to UI
    }

    override fun getItemCount(): Int = photos.size

    class MarsPhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Initialize views
    }
}