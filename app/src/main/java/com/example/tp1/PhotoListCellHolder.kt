package com.example.tp1

import androidx.recyclerview.widget.RecyclerView
import com.example.tp1.databinding.PhotoListCellBinding
import com.squareup.picasso.Picasso

class PhotoListCellHolder (photoListCellBinding: PhotoListCellBinding) : RecyclerView.ViewHolder(photoListCellBinding.root) {

    private val binding = photoListCellBinding

    fun bindItems(photo : Photos){
        binding.titlePhotoCell.text = photo.title
        Picasso.get().load(photo.thumbnailUrl).into(binding.thumbnailPhotoCell)
    }
}