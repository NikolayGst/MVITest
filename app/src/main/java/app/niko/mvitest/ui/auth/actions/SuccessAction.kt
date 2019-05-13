package app.niko.mvitest.ui.auth.actions

import app.niko.mvitest.ui.auth.LoginViewState
import app.niko.mvitest.ui.auth.SuccessState
import com.zuluft.mvi.actions.ViewStateAction

class SuccessAction : ViewStateAction<LoginViewState>() {
    override fun newState(oldState: LoginViewState): LoginViewState {
        return SuccessState
    }
}