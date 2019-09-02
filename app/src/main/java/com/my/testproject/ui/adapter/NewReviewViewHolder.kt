package com.my.testproject.ui.adapter


import android.view.View


import androidx.recyclerview.widget.RecyclerView

import com.my.testproject.R
import com.my.testproject.network.models.Genre
import com.my.testproject.network.models.Movie

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_review.view.*


class NewReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(mMovieReview: Movie, genre: Genre?) {

        itemView.movie_review_date.text = mMovieReview.releaseDate
        itemView.movie_review_content.text = mMovieReview.overview
        itemView.movie_review_genre.text = genre?.name

        Picasso.with(itemView.review_images.context).load(movieImagePathBuilder(mMovieReview.posterPath))
            .placeholder(R.drawable.ic_launcher_background).fit().centerCrop().into(itemView.review_images)

    }

    fun movieImagePathBuilder(imagePath: String?): String {
        return "https://image.tmdb.org/t/p/" +
                "w500" +
                imagePath
    }
}
