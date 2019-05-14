package app.niko.mvitest.ui.auth


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import app.niko.mvitest.R
import app.niko.mvitest.domain.models.UserDataModel
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.zuluft.mvi.annotations.LayoutResourceId
import com.zuluft.mvi.fragments.BaseFragment
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_login.*

@LayoutResourceId(R.layout.fragment_login)
class LoginFragment : BaseFragment<LoginViewState, LoginPresenter>(), LoginView {

    companion object {
        fun newInstance() : LoginFragment {
            return LoginFragment().apply {
                arguments = Bundle()
            }
        }
    }

    override fun onPresenterReady(presenter: LoginPresenter) {
        presenter.attach(this)
    }

    override fun reflectState(state: LoginViewState) {
        println("state: $state")
        when (state) {
            is LoadingState -> showLoading()
            is ErrorState -> showError(state.throwable)
        }
    }

    private fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    private fun showError(throwable: Throwable) {
        progress_bar.visibility = View.GONE
        AlertDialog.Builder(requireContext())
                .setMessage(throwable.message)
                .setPositiveButton("OK", null)
                .show()
    }

    override fun renderView(view: View?, savedInstanceState: Bundle?) {
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
