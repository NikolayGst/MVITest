package app.niko.mvitest.ui.auth.actions

import app.niko.mvitest.ui.auth.LoginNavigator
import com.zuluft.mvi.actions.NavigatorAction

class GoToHomePageAction(loginNavigator: LoginNavigator) : NavigatorAction<LoginNavigator>(loginNavigator) {
    override fun commitNavigatorAction() {
        navigator.goToHomePage()
    }
}