package com.my.testproject.ui

import com.fasterxml.jackson.databind.ser.Serializers
import com.my.testproject.BaseContract
import com.my.testproject.network.models.Genre
import com.my.testproject.network.models.Genres
import com.my.testproject.network.models.Movie
import com.my.testproject.network.models.Movies

interface MainContract {


    interface View {

        fun showLoading(isProgress:Boolean)
        fun showData(genres:List<Genre>, movies:List<Movie>)
    }

    interface Presenter {

       fun onViewCreated(view:View)

    }
}