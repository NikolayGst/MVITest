package app.niko.mvitest.ui.main.actions

import app.niko.mvitest.ui.main.DrawHomeScreen
import app.niko.mvitest.ui.main.MainViewState
import com.zuluft.mvi.actions.ViewStateAction

class DrawHomeScreenAction : ViewStateAction<MainViewState>() {
    override fun newState(oldState: MainViewState): MainViewState {
        return DrawHomeScreen
    }
}