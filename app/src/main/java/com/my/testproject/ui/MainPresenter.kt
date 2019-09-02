package com.my.testproject.ui

import android.annotation.SuppressLint
import android.util.Log
import com.my.testproject.App
import com.my.testproject.network.MovieService
import com.my.testproject.network.models.Genres
import com.my.testproject.network.models.Movies
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainPresenter : MainContract.Presenter{

    private lateinit var view: MainContract.View

    init {
        App().getAppComponent().inject(this)
    }

    @Inject
    lateinit var movieService: MovieService


    override fun onViewCreated(view: MainContract.View) {
        attachedView(view)
        loadMovies()
    }

    private fun attachedView(view: MainContract.View) {
        this.view = view
    }

    private fun loadMovies() {

        fun execute(releaseDate: String, page: Int): Observable<Movies> {
            return movieService.getMovies(releaseDate, "primary_release_date.asc", page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }


        execute(getReleaseDate(), page).subscribe(object : Subscriber<Movies>() {
            override fun onCompleted() {
                Log.d(TAG, "onCompleted: loadMovies")
            }

            override fun onError(e: Throwable) {
                //view.showError()
                defaultErrorHandling(e)
            }

            override fun onNext(movies: Movies) {

                loadGenre(movies)
            }
        })
    }

    private fun loadGenre(movies: Movies){

        fun execute(): Observable<Genres> {
            return movieService.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
        execute().subscribe(object : Subscriber<Genres>() {
            override fun onCompleted() {

                Log.d(TAG, "onCompleted: loadGenres")
            }

            override fun onError(e: Throwable) {
                defaultErrorHandling(e)
            }

            override fun onNext(genres: Genres) {

                val genresList = genres.genres
                val moviesList =  movies.movies

                view.showData(genresList!!, moviesList!!)

            }
        })

    }

    fun getReleaseDate(): String {

        val cal = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
        val format1 = SimpleDateFormat("yyyy-MM-dd")
        return format1.format(cal.time)
    }
    private fun defaultErrorHandling(e: Throwable) {
        Log.e(TAG, Log.getStackTraceString(e))
    }
    private val TAG = "MAIN PRESENTER"
    private val page = 1


}