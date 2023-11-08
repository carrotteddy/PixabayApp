package com.example.pixabayapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pixabayapp.databinding.ActivityMainBinding
import com.example.pixabayapp.model.ImageModel
import com.example.pixabayapp.model.PixabayApi
import com.example.pixabayapp.view.PixabayView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PixabayView {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var presenter: Presenter
    private val adapter = ImageAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        binding.btnSearch.setOnClickListener {
            presenter.getPixabay(binding.etSearch.text.toString())
        }

    }

    override fun showPixabay(pixabayModel: ArrayList<ImageModel>) {
        val rv = binding.rvImages
        val layoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        rv.adapter = adapter
        adapter.clearData()
        adapter.addData(pixabayModel)
        adapter.notifyDataSetChanged()
    }

}