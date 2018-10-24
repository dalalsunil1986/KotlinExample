package com.kotlin.example.di.component

import android.app.Application
import com.kotlin.example.MainApplication
import com.kotlin.example.di.builder.ActivityBuilder
import com.kotlin.example.di.module.AppModule
import com.kotlin.example.di.module.NetworkModule
import com.kotlin.example.ui.RecipesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(cayenneApplication: MainApplication): Builder

        fun build(): AppComponent
    }

    fun inject(cayenneApplication: MainApplication)

}