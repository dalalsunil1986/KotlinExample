package com.kotlin.example.di.module

import android.app.Application
import android.content.Context
import com.kotlin.example.MainApplication
import com.kotlin.example.data.AppDataManager
import com.kotlin.example.data.Config
import com.kotlin.example.data.DataManager

import com.kotlin.example.data.network.ApiHelper
import com.kotlin.example.data.network.AppApiHelper
import com.kotlin.example.di.ApplicationContext
import com.kotlin.example.di.BaseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(cayenneApplication: MainApplication): Context {
        return cayenneApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(cayenneApplication: MainApplication): Application {
        return cayenneApplication
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }



    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApixHelper: AppApiHelper): ApiHelper {
        return appApixHelper
    }

}