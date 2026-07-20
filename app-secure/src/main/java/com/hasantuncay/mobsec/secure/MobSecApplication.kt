package com.hasantuncay.mobsec.secure

import android.app.Application
import timber.log.Timber

class MobSecApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
