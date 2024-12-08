package com.example.apistart.di

import com.example.apistart.data.api.ApiClient
import com.example.apistart.data.api.ApiDetails
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module //tells hilt that here are definitions to be injected
@InstallIn(SingletonComponent::class) //tells hilt how long should a dependency survive
class AppModule {

    @Provides
    fun provideRetrofit(
        converterFactory: GsonConverterFactory,
        okhttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideApiClient(
        retrofit: Retrofit
    ): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providerOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
}