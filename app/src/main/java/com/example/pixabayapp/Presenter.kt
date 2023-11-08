package com.example.pixabayapp

import android.util.Log
import com.example.pixabayapp.model.PixabayApi
import com.example.pixabayapp.model.PixabayModel
import com.example.pixabayapp.view.PixabayView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val api: PixabayApi) {

    lateinit var view: PixabayView

    fun getPixabay(keyWord: String) {
        api.getImage(keyWord).enqueue(object : Callback<PixabayModel> {
            override fun onResponse(call: Call<PixabayModel>, response: Response<PixabayModel>) {
                if (response.isSuccessful) {
                    if (response.body() != null){
                    view.showPixabay(response.body()!!.hits)
                    }
                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("osibka", "oshibka")
            }
        })
    }

    fun attachView(view: PixabayView) {
        this.view = view
    }

}