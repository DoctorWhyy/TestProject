package com.my.testproject.network.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Genres(
    @JsonProperty("genres")
    var genres: List<Genre>? = null,
    @JsonProperty("id")
    var id: Int = 0,
    @JsonProperty("name")
    var name: String? = null
)