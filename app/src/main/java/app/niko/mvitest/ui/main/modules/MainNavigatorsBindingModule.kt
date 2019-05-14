package app.niko.mvitest.ui.main.modules

import app.niko.mvitest.ui.auth.LoginNavigator
import app.niko.mvitest.ui.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainNavigatorsBindingModule {

    @Binds
    abstract fun bingLoginNavigator(mainPresenter: MainPresenter): LoginNavigator
}