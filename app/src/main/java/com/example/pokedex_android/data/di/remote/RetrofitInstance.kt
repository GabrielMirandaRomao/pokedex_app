package com.example.pokedex_android.data.di.remote

import com.example.pokedex_android.data.remote.service.IPokemonApiService
import com.example.pokedex_android.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    @Singleton
    @Provides
    fun provideLoginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(okHttpLoginInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(okHttpLoginInterceptor)
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonApiService(retrofit: Retrofit): IPokemonApiService {
        return retrofit.create(IPokemonApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideRetrofitSecondInstance(
//        gsonConverterFactory: GsonConverterFactory,
//        okHttpClient: OkHttpClient
//    ): Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(BASE_SECOND_ENDPOINT_URL)
//            .addConverterFactory(gsonConverterFactory)
//            .client(okHttpClient)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun providePokedevApiService(retrofit: Retrofit): IPokedevApiService {
//        return retrofit.create(IPokedevApiService::class.java)
//    }
}