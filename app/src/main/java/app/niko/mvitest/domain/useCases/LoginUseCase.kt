package app.niko.mvitest.domain.useCases

import app.niko.mvitest.domain.models.UserDataModel
import app.niko.mvitest.domain.repo.Repository
import app.niko.mvitest.ui.auth.actions.ErrorAction
import com.zuluft.mvi.useCases.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class LoginUseCase
@Inject constructor(repository: Repository)
    : BaseUseCase<Repository, UserDataModel, String>(repository) {
    override fun createObservable(arg: UserDataModel?): Observable<String> {
        return repository.login(arg!!).map { it.result }
    }
}