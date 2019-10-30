package com.example.namazandroidapp.data.network

import com.example.namazandroidapp.data.entity.network.ItemResponse


interface IApiRepository {

    suspend fun getListItems(): List<ItemResponse>
}