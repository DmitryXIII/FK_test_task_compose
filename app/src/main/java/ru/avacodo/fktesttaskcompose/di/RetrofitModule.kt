package ru.avacodo.fktesttaskcompose.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.avacodo.fktesttaskcompose.BuildConfig
import ru.avacodo.fktesttaskcompose.data.remote.FitDataApi
import javax.inject.Singleton

private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideFitDataApi(): FitDataApi {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            addCallAdapterFactory(CoroutineCallAdapterFactory())
            client(
                OkHttpClient.Builder().apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    }
                }.build()
            )
        }.build().create(FitDataApi::class.java)
    }
}