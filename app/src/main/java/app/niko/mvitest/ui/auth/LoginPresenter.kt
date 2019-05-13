package app.niko.mvitest.ui.auth

import app.niko.mvitest.domain.models.UserDataModel
import app.niko.mvitest.domain.useCases.LoginUseCase
import app.niko.mvitest.ui.auth.actions.ErrorAction
import app.niko.mvitest.ui.auth.actions.LoadingAction
import app.niko.mvitest.ui.auth.actions.SuccessAction
import com.zuluft.mvi.actions.Action
import com.zuluft.mvi.presenters.BasePresenter
import com.zuluft.mvi.scopes.PerActivity
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@PerActivity
class LoginPresenter @Inject constructor(private val loginUseCase: LoginUseCase)
    : BasePresenter<LoginViewState, LoginContract.LoginView>() {

    override fun getInitialViewState(): LoginViewState {
        return InitialState
    }

    override fun onAttach(isFirstAttach: Boolean) {
        registerPerViewDisposables(
                subscribeClickLoginIntent()
        )
    }

    private fun subscribeClickLoginIntent(): Disposable {
        return getView().onLoginClickIntent().subscribe {
            onLoginRequested(it)
        }
    }

    private fun onLoginRequested(userDataModel: UserDataModel) {
        registerPerPresenterDisposables(
                loginUseCase.createObservable(userDataModel)
                        .map { SuccessAction() }
                        .cast(Action::class.java)
                        .onErrorReturn { error -> ErrorAction(error) }
                        .startWith(LoadingAction())
                        .subscribe(this::dispatchAction)
        )
    }

    override fun onFirstAttach() {

    }
}