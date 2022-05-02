package net.megastudy.mvvmnavernewspractice_0429.util

import net.megastudy.mvvmnavernewspractice_0429.data.AModel
import net.megastudy.mvvmnavernewspractice_0429.data.NewsSearchData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkInterface {

    @GET("search/news.json") //news api address
    suspend fun getRequestNewsList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
    ): NewsSearchData
}