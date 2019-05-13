package app.niko.mvitest.app

import app.niko.mvitest.app.di.AppComponent
import app.niko.mvitest.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    private lateinit var component: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

    override fun onCreate() {
        component = DaggerAppComponent.builder().application(this).build()
        super.onCreate()
    }

}