package app.niko.mvitest.domain.repo

import app.niko.mvitest.domain.models.UserDataModel
import app.niko.mvitest.domain.responseModels.LoginResponseModel
import io.reactivex.Observable


interface Repository {
    fun login(model: UserDataModel): Observable<LoginResponseModel>
}