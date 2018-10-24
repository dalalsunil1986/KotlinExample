package com.kotlin.example.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.widget.Toast
import com.kotlin.example.R
import com.kotlin.example.databinding.ActivityMainBinding
import com.kotlin.example.model.FoodItem
import com.kotlin.example.ui.base.BaseActivity
import com.kotlin.example.ui.base.SpacingItemDecoration
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var presenter: MainPresenter<MainView>

    private lateinit var binding: ActivityMainBinding
    private val foodAdapter = FoodAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = foodAdapter
        binding.layoutManager = GridLayoutManager(this, 2)
        binding.dividerItemDecoration = SpacingItemDecoration(2, dpToPx(this, 3), true)

        presenter.onAttach(this)

        presenter.loadPost()
        //presenter.onViewCreated()
    }

    fun dpToPx(c: Context, dp: Int): Int {
        val r = c.resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun updatePosts(posts: List<FoodItem>) {
        foodAdapter.updatePosts(posts)

    }


}
