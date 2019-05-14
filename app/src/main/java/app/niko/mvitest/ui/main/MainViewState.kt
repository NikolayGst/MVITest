package app.niko.mvitest.ui.main

sealed class MainViewState
object DrawLoginScreen: MainViewState()
object DrawHomeScreen: MainViewState()