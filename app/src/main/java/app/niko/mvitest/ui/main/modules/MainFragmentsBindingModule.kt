package app.niko.mvitest.ui.main.modules

import app.niko.mvitest.ui.auth.LoginFragment
import app.niko.mvitest.ui.home.HomeFragment
import com.zuluft.mvi.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}