package com.kotlin.example.di.builder

import com.kotlin.example.di.module.AppModule
import com.kotlin.example.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import android.app.Activity
import com.kotlin.example.di.component.AppComponent
import com.kotlin.example.di.module.NetworkModule
import com.kotlin.example.ui.RecipesModule
import dagger.android.AndroidInjector
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import dagger.Binds

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(RecipesModule::class)])
    abstract fun bindMainActivty(): MainActivity


}