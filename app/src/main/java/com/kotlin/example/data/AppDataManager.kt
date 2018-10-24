package com.kotlin.example.data


import com.kotlin.example.data.network.AppApiHelper;

import javax.inject.Inject


class AppDataManager @Inject
constructor(private val appApiHelper: AppApiHelper) :
    DataManager {

    override fun getAll() =
            appApiHelper.getAll()
}
