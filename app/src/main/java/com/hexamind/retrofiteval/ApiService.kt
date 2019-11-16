package com.hexamind.retrofiteval

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/bins/tx23m")
    fun json(): Call<JsonClass>
}
