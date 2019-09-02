package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Movies(

    @JsonProperty("page")
    var page: Int = 0,
    @JsonProperty("results")
    var movies: List<Movie>? = null,
    @JsonProperty("total_results")
    var totalResults: Int = 0,
    @JsonProperty("total_pages")
    var totalPages: Int = 0
)