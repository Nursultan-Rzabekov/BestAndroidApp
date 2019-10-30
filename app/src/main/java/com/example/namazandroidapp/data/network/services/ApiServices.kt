package com.example.namazandroidapp.data.network.services

import com.example.namazandroidapp.data.entity.network.ItemResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface ApiServices {

    @GET("/en/web/good-radio-online/api-get-category")
    fun getListAsync(): Deferred<List<ItemResponse>>

}