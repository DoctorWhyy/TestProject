package com.my.testproject.di.component

import com.my.testproject.App
import com.my.testproject.di.module.ActivityModule
import com.my.testproject.ui.MainActivity
import com.my.testproject.di.module.AppModule
import com.my.testproject.di.module.NetModule
import com.my.testproject.network.MovieService
import com.my.testproject.ui.MainPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class,NetModule::class, ActivityModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(app: App)

}