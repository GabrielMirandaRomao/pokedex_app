package com.example.pokedex_android.data.remote.service

import com.example.pokedex_android.util.Constants.Companion.BASE_URL
import com.example.pokedex_android.util.Constants.Companion.BASE_SECOND_ENDPOINT_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val api : IPokemonApiService by lazy {
        retrofit.create(IPokemonApiService::class.java)
    }

    private val retrofit_second_api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_SECOND_ENDPOINT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val apiTwo : IPokedevApiService by lazy {
        retrofit_second_api.create(IPokedevApiService::class.java)
    }
}