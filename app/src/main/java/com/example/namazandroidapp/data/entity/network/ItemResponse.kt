package com.example.namazandroidapp.data.entity.network

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)