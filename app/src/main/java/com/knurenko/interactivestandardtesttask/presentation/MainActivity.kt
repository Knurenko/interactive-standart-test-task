package com.knurenko.interactivestandardtesttask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.knurenko.interactivestandardtesttask.R
import com.knurenko.interactivestandardtesttask.di.AppComponent
import com.knurenko.interactivestandardtesttask.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}