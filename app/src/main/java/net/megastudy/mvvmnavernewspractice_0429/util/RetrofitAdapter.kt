package net.megastudy.mvvmnavernewspractice_0429.util

import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.megastudy.mvvmnavernewspractice_0429.common.printRequestBody
import net.megastudy.mvvmnavernewspractice_0429.common.printResponseBody
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitAdapter {

    fun setupRetrofitWithTikXml(): Retrofit {

        val http = "https://openapi.naver.com/v1/"

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(LoggerInterceptorr())
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.SECONDS)
            .writeTimeout(3, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(http)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }
}


class LoggerInterceptorr : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        Log.e(
            "api", "conn-request : ${
                response.request.url.toString().plus("?").plus(response.printRequestBody())
            }"
        )
        Log.e("api", "conn-response : ${response.printResponseBody()}")

        return response
    }
}