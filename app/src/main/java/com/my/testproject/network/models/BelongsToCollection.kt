package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class BelongsToCollection(

    @JsonProperty("id")
    var id: Int = 0,
    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("poster_path")
    var posterPath: String? = null,
    @JsonProperty("backdrop_path")
    var backdropPath: String? = null
)