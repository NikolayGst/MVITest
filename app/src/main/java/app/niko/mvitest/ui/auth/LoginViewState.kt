package app.niko.mvitest.ui.auth

sealed class LoginViewState
object InitialState : LoginViewState()
object LoadingState : LoginViewState()
data class ErrorState(val throwable: Throwable) : LoginViewState()
object SuccessState: LoginViewState()