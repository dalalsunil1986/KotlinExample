package com.kotlin.example.ui

import android.support.annotation.StringRes;
import com.kotlin.example.model.FoodItem
import com.kotlin.example.ui.base.MvpView

interface MainView : MvpView {
    fun updatePosts(posts: List<FoodItem>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */


    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()



}
