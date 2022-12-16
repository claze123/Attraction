package com.claze2022.attraction1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Dothome2Interface {
    @GET("PrWeb/Pr1Retrofit/sample2.php")
    fun dothome2Data(@Query("POST_SJ") post_sj:String ) : Call<MutableList<BoardItem>>
}
