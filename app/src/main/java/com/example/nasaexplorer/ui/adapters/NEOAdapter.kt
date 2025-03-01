package com.example.nasaexplorer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaexplorer.R
import com.example.nasaexplorer.data.models.NEO

class NEOAdapter(private var neoList: List<NEO>) : RecyclerView.Adapter<NEOAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.neoNameTextView)
        val diameterTextView: TextView = itemView.findViewById(R.id.neoDiameterTextView)
        val hazardousTextView: TextView = itemView.findViewById(R.id.neoHazardousTextView)
        val approachDateTextView: TextView = itemView.findViewById(R.id.neoApproachDateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_neo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neo = neoList[position]
        holder.nameTextView.text = "Name: ${neo.name}"
        holder.diameterTextView.text = "Diameter: ${neo.estimated_diameter.kilometers.estimated_diameter_min} - ${neo.estimated_diameter.kilometers.estimated_diameter_max} km"
        holder.hazardousTextView.text = "Hazardous: ${neo.is_potentially_hazardous_asteroid}"
        holder.approachDateTextView.text = "Approach Date: ${neo.close_approach_data[0].close_approach_date}"
    }

    override fun getItemCount() = neoList.size

    fun updateData(newNEOList: List<NEO>) {
        neoList = newNEOList
        notifyDataSetChanged()
    }
}