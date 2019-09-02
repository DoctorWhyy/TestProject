package com.my.testproject.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.my.testproject.R
import com.my.testproject.network.models.Genre
import com.my.testproject.network.models.Movie

class NewReviewAdapter(private val mMovieReviews: List<Movie>, private val genres: List<Genre>?) :
    RecyclerView.Adapter<NewReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_movie_review, parent, false)
        return NewReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewReviewViewHolder, position: Int) {

        val mMovieReview = mMovieReviews[position]

        val mGenreReview = genres?.get(position)
        holder.bind(mMovieReview,mGenreReview)
    }

    override fun getItemCount(): Int {
        return this.mMovieReviews.size
    }

}
