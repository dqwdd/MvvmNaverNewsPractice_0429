package net.megastudy.mvvmnavernewspractice_0429.util

import android.util.Log
import com.google.gson.GsonBuilder
import net.megastudy.mvvmnavernewspractice_0429.common.printRequestBody
import net.megastudy.mvvmnavernewspractice_0429.common.printResponseBody
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    companion object {

        //서버 주소
        private const val hostURL = "https://openapi.naver.com/v1/"


        private var retrofit: Retrofit? = null
        fun getRetrofit(): Retrofit {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(LoggerInterceptor())


            if (retrofit == null) {
                val interceptor = Interceptor {
                    with(it) {
                        val newRequest = request().newBuilder()
                            .build()
                        proceed(newRequest)
                    }
                }

                retrofit = Retrofit.Builder()
                    .baseUrl(hostURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build()
            }
            return retrofit!!
        }
    }
}

class LoggerInterceptor : Interceptor {
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