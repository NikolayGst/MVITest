package app.niko.mvitest.domain.repo

import app.niko.mvitest.domain.models.UserDataModel
import app.niko.mvitest.domain.responseModels.LoginResponseModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MockRepositoryImpl : Repository {
    override fun login(model: UserDataModel): Observable<LoginResponseModel> {
        return Observable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map { LoginResponseModel() }
    }
}