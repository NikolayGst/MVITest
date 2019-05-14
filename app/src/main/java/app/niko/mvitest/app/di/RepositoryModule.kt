package app.niko.mvitest.app.di

import app.niko.mvitest.domain.repo.MockRepositoryImpl
import app.niko.mvitest.domain.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMockRepository(): Repository {
        return MockRepositoryImpl()
    }
}