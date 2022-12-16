package com.claze2022.attraction1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CultureRetrofitService {
    @GET("/41534c786d686f6e37395868555757/json/TbVwAttractions/1/1000")
    fun cultureData() :Call<CultureAttraction>


}