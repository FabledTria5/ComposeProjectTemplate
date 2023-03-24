package dev.fabled.composeprojecttemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.fabled.common.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}