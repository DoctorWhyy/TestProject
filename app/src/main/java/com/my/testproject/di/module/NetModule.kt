package com.my.testproject.di.module

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.my.testproject.BuildConfig
import com.my.testproject.Constants.BASE_URL
import com.my.testproject.R
import com.my.testproject.network.MovieService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {


    @Provides
    internal fun provideAuthenticationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    internal fun provideOkHttpClient(authenticationInterceptor: Interceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)


        return OkHttpClient.Builder()
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    internal fun provideJacksonConverterFactory(): JacksonConverterFactory {
        val objectMapper = ObjectMapper()
        return JacksonConverterFactory
            .create(objectMapper)
    }

    @Provides
    fun provideRetrofit(
        jacksonConverterFactory: JacksonConverterFactory,
        okHttpClient: OkHttpClient,
        @Named("applicationContext") context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(jacksonConverterFactory)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }


    @Provides
    fun provideApiService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}