package com.knurenko.interactivestandardtesttask.di

import com.knurenko.interactivestandardtesttask.presentation.MainActivity
import com.knurenko.interactivestandardtesttask.presentation.screens.main.MainFragment
import dagger.Component

/**
 * @author Knurenko Bogdan 12.12.2023
 */

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
}