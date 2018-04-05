package toolgamecorporation.worldcupschedule.di.module

import dagger.Module
import dagger.Provides
import toolgamecorporation.worldcupschedule.data.UpcReposImpl
import toolgamecorporation.worldcupschedule.data.repository.UpcRepos
import javax.inject.Singleton

/**
 * Created by Dell on 3/20/2018.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesLoginRepository(repository: UpcReposImpl): UpcRepos {
        return repository
    }
}