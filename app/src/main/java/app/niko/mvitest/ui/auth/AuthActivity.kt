package app.niko.mvitest.ui.auth


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import app.niko.mvitest.R
import app.niko.mvitest.domain.models.UserDataModel
import app.niko.mvitest.ui.home.HomeActivity
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.zuluft.mvi.activities.BaseActivity
import com.zuluft.mvi.annotations.LayoutResourceId
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_auth.*

@LayoutResourceId(R.layout.activity_auth)
class AuthActivity : BaseActivity<LoginViewState, LoginPresenter>(), LoginContract.LoginView {

    override fun onPresenterReady(presenter: LoginPresenter) {
        presenter.attach(this)
    }

    override fun reflectState(state: LoginViewState) {
        println("state: $state")
        when (state) {
            is LoadingState -> showLoading()
            is ErrorState -> showError(state.throwable)
            is SuccessState -> openHomePage()
        }
    }

    private fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    private fun showError(throwable: Throwable) {
        progress_bar.visibility = View.GONE
        AlertDialog.Builder(this)
                .setMessage(throwable.message)
                .setPositiveButton("OK", null)
                .show()
    }

    private fun openHomePage() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun renderView(savedInstanceState: Bundle?) {
        registerDisposables(
                Observable.combineLatest(
                        RxTextView.textChanges(loginEdit),
                        RxTextView.textChanges(passwordEdit),
                        BiFunction { t1: CharSequence, t2: CharSequence ->
                            t1.isNotEmpty() && t2.isNotEmpty()
                        }
                ).subscribe {
                    btnSignIn.isEnabled = it
                }
        )
    }

    override fun onLoginClickIntent(): Observable<UserDataModel> {
        return RxView.clicks(btnSignIn)
                .map {
                    val login = loginEdit.text.toString()
                    val password = passwordEdit.text.toString()
                    UserDataModel(login, password)
                }
    }

}
