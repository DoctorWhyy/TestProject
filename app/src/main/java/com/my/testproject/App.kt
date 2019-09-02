package com.my.testproject

import android.app.Application
import com.my.testproject.di.component.AppComponent
import com.my.testproject.di.component.DaggerAppComponent
import com.my.testproject.di.module.ActivityModule
import com.my.testproject.di.module.AppModule
import com.my.testproject.di.module.NetModule

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        setup()
    }


    fun setup() {

        component = DaggerAppComponent.builder().appModule(AppModule(this)).activityModule(
            ActivityModule()
        ).netModule(NetModule())
            .build()

        component.inject(this)


    }

    companion object{
        lateinit var component: AppComponent
    }

    fun getAppComponent(): AppComponent {
        return component
    }
}