package app.niko.mvitest.app.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application) : Context {
        return application.applicationContext
    }
}