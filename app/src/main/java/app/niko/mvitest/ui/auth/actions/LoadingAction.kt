package app.niko.mvitest.ui.auth.actions

import app.niko.mvitest.ui.auth.LoadingState
import app.niko.mvitest.ui.auth.LoginViewState
import com.zuluft.mvi.actions.ViewStateAction

class LoadingAction : ViewStateAction<LoginViewState>() {
    override fun newState(oldState: LoginViewState): LoginViewState {
        return LoadingState
    }

}