package com.claze2022.attraction1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DothomeInterface {
    @GET("PrWeb/Pr1Retrofit/sample.php")
    fun dothomeData(@Query("message")msg:String,@Query ("POST_SN")post_sn:String, @Query("POST_SJ")post_sj:String) : Call<String>
}