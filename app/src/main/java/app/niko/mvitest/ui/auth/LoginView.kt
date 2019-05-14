package app.niko.mvitest.ui.auth

import app.niko.mvitest.domain.models.UserDataModel
import com.zuluft.mvi.views.BaseView
import io.reactivex.Observable

interface LoginView : BaseView<LoginViewState> {
    fun onLoginClickIntent(): Observable<UserDataModel>
}