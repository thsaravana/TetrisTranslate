package com.madrapps.tetristranslate.di

import android.app.Application
import com.madrapps.tetristranslate.TetrisApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        GameModule::class
    ]
)
interface AppComponent : AndroidInjector<TetrisApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: TetrisApplication)
}