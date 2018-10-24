package com.kotlin.example.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

import dagger.Module
import dagger.Provides


@Module
class RecipesModule {

    @Provides
    fun provideRecipesMvpPresenter(presenter: MyPresenter<MainView>): MainPresenter<MainView> {
        return presenter
    }




}