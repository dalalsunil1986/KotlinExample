package com.kotlin.example.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.example.R
import com.kotlin.example.model.FoodItem
import com.kotlin.example.databinding.ItemFoodBinding

/**
 * Adapter for the list of the posts
 * @property context Context in which the application is running
 */
class FoodAdapter(private val context: Context) : RecyclerView.Adapter<FoodAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemFoodBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_food, parent, false)
        return PostViewHolder(binding)    }

    /**
     * The list of posts of the adapter
     */
    private var items: List<FoodItem> = listOf()



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder?.bind(items[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(posts: List<FoodItem>) {
        this.items = posts
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    class PostViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(post: FoodItem) {
            binding.food = post
            binding.executePendingBindings()
        }
    }
}