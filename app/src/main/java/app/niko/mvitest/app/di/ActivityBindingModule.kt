package app.niko.mvitest.app.di

import app.niko.mvitest.ui.auth.AuthActivity
import com.zuluft.mvi.scopes.PerActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindAuthActivity(): AuthActivity
}