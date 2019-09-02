package com.my.testproject.di.module

import com.my.testproject.ui.MainActivity
import com.my.testproject.ui.MainContract
import com.my.testproject.ui.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideMainActivity():MainContract.View{

        return MainActivity()
    }
    @Provides
    fun provideMainPResenter():MainContract.Presenter{

        return MainPresenter()
    }


}