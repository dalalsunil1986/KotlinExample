// Safe here as method are used by Data binding
@file:Suppress("unused")

package com.kotlin.example.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kotlin.example.ui.FoodAdapter
import com.kotlin.example.ui.base.SpacingItemDecoration

/**
 * Sets an adapter to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the adapter
 * @param adapter the adapter to set to the RecyclerView
 */


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: FoodAdapter) {
    view.adapter = adapter
}

/**
 * Sets a LayoutManager to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the LayoutManager
 * @param layoutManager the LayoutManager to set to the RecyclerView
 */
@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

/**
 * Adds a DividerItemDecoration to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the DividerItemDecoration
 * @param dividerItemDecoration the DividerItemDecoration to set to the RecyclerView
 */
@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: SpacingItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}


@BindingAdapter("android:profileImage")
fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.context).load("https://appfood123.herokuapp.com/image/" + url).into(view)
}

