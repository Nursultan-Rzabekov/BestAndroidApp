package com.example.namazandroidapp.data.network

import com.example.namazandroidapp.data.entity.network.ItemResponse
import com.example.namazandroidapp.data.network.services.ApiServices


class ApiRepository(private val apiServices: ApiServices): IApiRepository {

    override suspend fun getListItems(): List<ItemResponse> = apiServices.getListAsync().await()
}