package com.example.nasaexplorer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaexplorer.R
import com.example.nasaexplorer.data.models.MarsPhoto

class MarsPhotosAdapter(private val photos: List<MarsPhoto>) : RecyclerView.Adapter<MarsPhotosAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.marsPhotoImageView)
        val dateTextView: TextView = itemView.findViewById(R.id.marsPhotoDateTextView)
        val roverNameTextView: TextView = itemView.findViewById(R.id.marsRoverNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mars_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        Glide.with(holder.itemView.context)
            .load(photo.img_src)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(holder.imageView)

        holder.dateTextView.text = "Earth Date: ${photo.earth_date}"
        holder.roverNameTextView.text = "Rover: ${photo.rover.name}"
    }

    override fun getItemCount() = photos.size
}