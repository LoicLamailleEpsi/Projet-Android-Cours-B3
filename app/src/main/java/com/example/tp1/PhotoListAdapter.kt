package com.example.tp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1.databinding.PhotoListCellBinding

class PhotoListAdapter (photoArray : Array<Photos>, photoListClickListener: OnPhotoListClickListener) : RecyclerView.Adapter<PhotoListCellHolder>(){

    private val dataSource = photoArray
    private val listener = photoListClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListCellHolder {
        val photoListCellBinding = PhotoListCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoListCellHolder(photoListCellBinding)
    }

    override fun onBindViewHolder(holder: PhotoListCellHolder, position: Int) {
        holder.bindItems(dataSource[position])
        holder.itemView.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(p0: View?) {
                listener.clickOnPhotoAction(dataSource[holder.adapterPosition])
            }

        })
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

}