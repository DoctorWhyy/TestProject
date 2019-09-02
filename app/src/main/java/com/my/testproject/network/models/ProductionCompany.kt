package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductionCompany (

    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("id")
    var id: Int = 0
)