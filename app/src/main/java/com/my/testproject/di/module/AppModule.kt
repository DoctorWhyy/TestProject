package com.my.testproject.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule(var application: Application) {

    @Provides
    @Named("applicationContext")
    fun providesApplication(): Context {
        return application
    }
}