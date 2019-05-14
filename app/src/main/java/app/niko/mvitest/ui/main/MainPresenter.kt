package app.niko.mvitest.ui.main

import app.niko.mvitest.ui.auth.LoginNavigator
import app.niko.mvitest.ui.main.actions.DrawHomeScreenAction
import com.zuluft.mvi.presenters.BasePresenter
import com.zuluft.mvi.scopes.PerActivity
import javax.inject.Inject

@PerActivity
class MainPresenter
        @Inject constructor():
        BasePresenter<MainViewState, MainView>(),
        LoginNavigator {

    override fun goToHomePage() {
        dispatchAction(DrawHomeScreenAction())
    }

    override fun getInitialViewState() = DrawLoginScreen

    override fun onAttach(isFirstAttach: Boolean) {

    }

    override fun onFirstAttach() {

    }
}