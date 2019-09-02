package com.my.testproject.network.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Genre (
    @JsonProperty("id")
    var id: Int? = null,

    @JsonProperty("name")
var name: String? = null)