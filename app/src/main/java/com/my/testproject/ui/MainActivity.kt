package com.my.testproject.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.testproject.App
import com.my.testproject.BaseActivity
import com.my.testproject.R
import com.my.testproject.ui.adapter.NewReviewAdapter
import com.my.testproject.network.models.Genre
import com.my.testproject.network.models.Movie
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        injectDependency()

        recyclerView = findViewById(R.id.reviews_list)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = NewReviewAdapter(mutableListOf(), mutableListOf())


        presenter.onViewCreated(this)    }

    override fun onStartScreen() {
        //TODO
    }

    override fun stopScreen() {
        //TODO
    }

    lateinit var recyclerView:RecyclerView

    private lateinit var adapter: NewReviewAdapter

    @Inject
    lateinit var presenter: MainContract.Presenter

    private fun injectDependency() {
        App.component.inject(this)
    }

    override fun showData(genres: List<Genre>, movies: List<Movie>) {

        adapter = NewReviewAdapter(movies, genres)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter


    }

    override fun showLoading(isProgress: Boolean) {
        //TODO
    }

}
