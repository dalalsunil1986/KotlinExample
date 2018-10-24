package com.kotlin.example.data.network


import com.kotlin.example.model.FoodItem

import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.POST



interface ApiService {

    @GET("/api/products")
    fun getAll(): Observable<List<FoodItem>>


}