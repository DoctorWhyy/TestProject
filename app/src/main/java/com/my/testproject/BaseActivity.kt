package com.my.testproject

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        //initialzeProgressDialog()
        init(savedInstanceState)

        //setupComponent()
    }

    @LayoutRes
    abstract fun setLayout(): Int
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun onStartScreen()
    abstract fun stopScreen()

    /*fun setupComponent(){
        val component = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        component.inject(this)

    }*/
    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
        /*  dismissProgress()
          mProgressDialog = null*/
    }

    override fun onStop() {
        super.onStop()
        stopScreen()
    }


}
