package com.lamarrulla.tragosapp.domain

import com.lamarrulla.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?s=")
    suspend fun getTragoByName(@Query("tragoName") tragoName:String) : DrinkList
}