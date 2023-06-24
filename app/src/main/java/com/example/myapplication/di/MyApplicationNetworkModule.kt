package com.example.myapplication.di

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.ServerDrivenResponse
import com.example.myapplication.data.Type1Response
import com.example.myapplication.data.Type2Response
import com.example.myapplication.data.TypeResponse
import com.example.myapplication.data.myscreen.remote.MyScreenApi
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyApplicationNetworkModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder()
        .add(
            ScreenType::class.java, EnumJsonAdapter.create(ScreenType::class.java)
                .withUnknownFallback(ScreenType.PROCESSING)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(ServerDrivenResponse::class.java, "type")
                .withSubtype(Type1Response::class.java, TypeResponse.Prueba.name)
                .withSubtype(Type2Response::class.java, TypeResponse.Prueba2.name)
        )
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor? = when {
        BuildConfig.DEBUG -> {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        else -> null
    }

    @Singleton
    @Provides
    internal fun providesOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient.Builder = OkHttpClient.Builder().apply {
        connectTimeout(15_000L, TimeUnit.MILLISECONDS)
        readTimeout(15_000L, TimeUnit.MILLISECONDS)
        writeTimeout(15_000L, TimeUnit.MILLISECONDS)
        loggingInterceptor?.also { addInterceptor(it) }
    }

    @Singleton
    @Provides
    internal fun providesOkHttpClient(
        builder: OkHttpClient.Builder,
    ): OkHttpClient = with(builder) {
        build()
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/fb853cab-3570-461f-b6fc-0a1c389d8af5/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    internal fun providesMyApplicationApi(retrofit: Retrofit): MyScreenApi =
        retrofit.create(MyScreenApi::class.java)
}
