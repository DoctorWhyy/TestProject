package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SpokenLanguage(

    @JsonProperty("iso_639_1")
    var iso6391: String? = null,
    @JsonProperty("name")
    var name: String? = null
)