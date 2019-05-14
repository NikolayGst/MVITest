package app.niko.mvitest.ui.main

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import app.niko.mvitest.R
import app.niko.mvitest.ui.auth.LoginFragment
import app.niko.mvitest.ui.home.HomeFragment
import com.zuluft.mvi.activities.BaseActivity
import com.zuluft.mvi.annotations.LayoutResourceId
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

@LayoutResourceId(R.layout.activity_main)
class MainActivity : BaseActivity<MainViewState, MainPresenter>(), HasSupportFragmentInjector, MainView {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onPresenterReady(presenter: MainPresenter) {
        presenter.attach(this)
    }

    override fun reflectState(state: MainViewState) {
        when (state) {
            DrawLoginScreen -> drawLoginScreen()
            DrawHomeScreen -> drawHomeScreen()
        }
    }


    private fun drawLoginScreen() {
        changeFragment(LoginFragment.newInstance(), "LOGIN_FRAGMENT_TAG", false)
    }

    private fun drawHomeScreen() {
        changeFragment(HomeFragment.newInstance(), "HOME_FRAGMENT_TAG", false)
    }

    private fun changeFragment(fragment: Fragment, tag: String, addToBackStack: Boolean,
                               cleanStack: Boolean = false, @IdRes id: Int = R.id.container) {
        safeFragmentTransaction.registerFragmentTransition {
            if (cleanStack) {
                it.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            val fragmentTransaction = it.beginTransaction()
            fragmentTransaction.replace(id, fragment, tag)
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(tag)
            }
            fragmentTransaction.commit()
        }
    }


    override fun renderView(savedInstanceState: Bundle?) {

    }


}
