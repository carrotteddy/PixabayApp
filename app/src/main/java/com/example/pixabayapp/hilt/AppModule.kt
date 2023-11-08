package com.example.pixabayapp.hilt

import com.example.pixabayapp.Presenter
import com.example.pixabayapp.model.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): PixabayApi{
        return Retrofit.Builder().baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(PixabayApi::class.java)
    }

    fun providePresenter(api: PixabayApi):Presenter{
        return Presenter(api)
    }

}