package dev.arunkumar.scabbard

import android.app.Application
import dev.arunkumar.scabbard.debug.ApplicationSingleton
import dev.arunkumar.scabbard.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {
    val appComponent by lazy { DaggerAppComponent.factory().build(this) }

    @Inject
    lateinit var applicationSingleton: ApplicationSingleton

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }
}

fun Application.appComponent() = (this as App).appComponent