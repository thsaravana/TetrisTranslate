package com.madrapps.tetristranslate.di

import com.madrapps.tetristranslate.GameActivity
import com.madrapps.tetristranslate.PlayFragment
import dagger.Module
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

}