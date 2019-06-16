package com.madrapps.tetristranslate.di

import androidx.lifecycle.ViewModelProviders
import com.madrapps.tetristranslate.GameActivity
import com.madrapps.tetristranslate.play.PlayFragment
import com.madrapps.tetristranslate.play.PlayViewModel
import com.madrapps.tetristranslate.play.PlayViewModelFactory
import com.madrapps.tetristranslate.play.PlayViewModelImpl
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class GameModule {

    @ContributesAndroidInjector
    abstract fun bindActivity(): GameActivity

    @ContributesAndroidInjector(modules = [PlayFragmentModule::class])
    abstract fun bindFragment(): PlayFragment
}

@Module
internal class PlayFragmentModule {

    @Provides
    fun provideViewModelFactory(): PlayViewModelFactory {
        return PlayViewModelFactory()
    }

    @Provides
    fun provideViewModel(factory: PlayViewModelFactory, fragment: PlayFragment): PlayViewModel {
        return ViewModelProviders.of(fragment, factory).get(PlayViewModelImpl::class.java)
    }
}