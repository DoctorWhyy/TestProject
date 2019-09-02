package com.my.testproject.network

import com.my.testproject.network.models.Genres
import com.my.testproject.network.models.Movies
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface MovieService{

    @GET("genre/movie/list")
    fun getGenres(): Observable<Genres>

    @GET("discover/movie")
     fun getMovies(
        @Query("primary_release_date.gte") releaseDate: String,
        @Query("sort_by") sortBy: String, @Query("page") page: Int
    ): Observable<Movies>

}
