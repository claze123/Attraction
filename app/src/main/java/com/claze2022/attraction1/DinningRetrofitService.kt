package com.claze2022.attraction1

import retrofit2.Call
import retrofit2.http.GET

interface DinningRetrofitService {
    @GET("/41534c786d686f6e37395868555757/json/TbVwRestaurants/1/1000/")
    fun dinningData() : Call<DinningAttraction>
}