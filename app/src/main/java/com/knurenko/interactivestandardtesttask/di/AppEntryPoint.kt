package com.knurenko.interactivestandardtesttask.di

import android.app.Application
import android.content.Context

/**
 * @author Knurenko Bogdan 13.12.2023
 */
class AppEntryPoint : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }

    companion object {
        fun getComponent(context: Context) = (context.applicationContext as AppEntryPoint).appComponent
    }
}