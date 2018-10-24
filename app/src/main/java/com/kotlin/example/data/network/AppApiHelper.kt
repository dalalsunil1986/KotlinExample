package com.kotlin.example.data.network

import javax.inject.Inject


class AppApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getAll() =
        apiService.getAll()

}