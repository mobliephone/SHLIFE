package com.sh.cgw.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 作者：created by cgw on 2019/6/19 21:51
 * 类注释：
 */
class RetrofitApi {

    companion object{

        private const val TAG = "RetrofitApi"

        private fun retrofit(url:String ):Retrofit{

            //显示日志级别
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                Log.e(TAG,"OkHttp:$message")
            })
            loggingInterceptor.level = level

            val okHttpClientBuilder = OkHttpClient.Builder()
            //设置超时
            okHttpClientBuilder.connectTimeout(60,TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(10,TimeUnit.SECONDS)

            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

        }

        fun<T> getRetrofitApi(url:String, service: Class<T>): T{
            return retrofit(url).create(service)
        }

        val retrofitService:RetrofitService = getRetrofitApi(
                Constants.URL_BASE, RetrofitService::class.java)


        val newsRetrofit:RetrofitService = getRetrofitApi(
                Constants.NEWS_BASE_URL, RetrofitService::class.java)

        val todayRetrofit:RetrofitService = getRetrofitApi(
                Constants.TODAY_BASE_URL, RetrofitService::class.java)

        val constellationRetrofit:RetrofitService = getRetrofitApi(
                Constants.CONSTELLATION_BASE_URL, RetrofitService::class.java
        )

        val odiomRetrofit:RetrofitService = getRetrofitApi(
                Constants.IDIOM_BASE_URL, RetrofitService::class.java
        )


    }

}