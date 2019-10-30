package com.example.namazandroidapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.namazandroidapp.data.entity.db.ItemDBModel
import io.reactivex.Flowable


interface IItemsRepository {

    suspend fun get(): List<ItemDBModel>

    suspend fun delete(model: ItemDBModel)

    suspend fun clear()

    fun observeLiveData(): LiveData<List<ItemDBModel>>

    fun observeReceiveChannel(): Flowable<List<ItemDBModel>>
}