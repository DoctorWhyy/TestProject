package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductionCountry (
    @JsonProperty("iso_3166_1")
    var iso31661: String? = null,
    @JsonProperty("name")
    var name: String? = null
)