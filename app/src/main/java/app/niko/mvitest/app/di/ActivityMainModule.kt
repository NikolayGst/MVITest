package app.niko.mvitest.app.di

import app.niko.mvitest.ui.main.MainActivity
import app.niko.mvitest.ui.main.modules.MainFragmentsBindingModule
import app.niko.mvitest.ui.main.modules.MainNavigatorsBindingModule
import com.zuluft.mvi.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityMainModule {

    @PerActivity
    @ContributesAndroidInjector(
            modules = [MainFragmentsBindingModule::class, MainNavigatorsBindingModule::class]
    )
    abstract fun bindMainAcitity(): MainActivity
}