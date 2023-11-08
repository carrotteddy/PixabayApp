package com.example.pixabayapp.view

import com.example.pixabayapp.model.ImageModel

interface PixabayView {
    fun showPixabay(pixabayModel: ArrayList<ImageModel>)
}