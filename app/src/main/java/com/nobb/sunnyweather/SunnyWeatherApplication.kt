package com.nobb.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication:Application() {
    companion object{
        const val TOKEN = "cNy3ryBmhzNBie40"

        @SuppressLint("StaticFieldLeak")
        lateinit var content:Context
    }

    override fun onCreate() {
        super.onCreate()
        content = applicationContext
    }
}