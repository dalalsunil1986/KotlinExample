package com.kotlin.example.data.network


import com.kotlin.example.model.FoodItem

import io.reactivex.Observable

interface ApiHelper {



    fun getAll(): Observable<List<FoodItem>>


}