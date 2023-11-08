package com.example.pixabayapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabayapp.databinding.ListItemPixabayBinding
import com.example.pixabayapp.model.ImageModel

class ImageAdapter(private val images:ArrayList<ImageModel>)
    :RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ListItemPixabayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(images[position])
    }

    inner class ImageViewHolder(var binding: ListItemPixabayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.imgPix.load(imageModel.webFormatUrl)
        }
    }

    fun clearData() {
        images.clear()
    }

    fun addData(newImages: List<ImageModel>) {
        images.addAll(newImages)
    }

}