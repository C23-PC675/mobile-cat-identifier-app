package com.dicoding.catidentifierapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatListAdapter(private val listAdapter: List<ResponseItem>) :
    RecyclerView.Adapter<CatListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvUserName.text = listAdapter[position].catRaces
        viewHolder.tvDescription.text = listAdapter[position].catDesc
        Glide.with(viewHolder.imgUserPhoto.context).load(listAdapter[position].catImage)
            .into(viewHolder.imgUserPhoto)

        viewHolder.itemView.setOnClickListener {
            val intentDetail = Intent(viewHolder.itemView.context, CatInformation::class.java)
            intentDetail.putExtra("CAT", listAdapter[position])
            viewHolder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listAdapter.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName: TextView = view.findViewById(R.id.title)
        val tvDescription: TextView = view.findViewById(R.id.description)
        val imgUserPhoto: ImageView = view.findViewById(R.id.image)
    }
}