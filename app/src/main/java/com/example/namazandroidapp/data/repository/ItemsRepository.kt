package com.example.namazandroidapp.data.repository

import androidx.lifecycle.LiveData
import com.example.namazandroidapp.data.entity.db.ItemDBModel
import com.example.namazandroidapp.data.entity.mappers.DbModelMapper
import com.example.namazandroidapp.data.network.IApiRepository
import com.example.namazandroidapp.data.storage.database.dao.IItemsDao
import com.example.namazandroidapp.domain.repository.IItemsRepository
import io.reactivex.Flowable
import javax.inject.Inject


class ItemsRepository @Inject constructor(
    private val apiRepository: IApiRepository,
    private val itemsDao: IItemsDao
): IItemsRepository {

    override suspend fun get(): List<ItemDBModel> {
        val listItems = apiRepository.getListItems()
        itemsDao.insert(listItems.map { model -> DbModelMapper.map(model) })
        return itemsDao.select()
    }

    override suspend fun delete(model: ItemDBModel) {
        itemsDao.delete(model)
    }

    override suspend fun clear() {
        itemsDao.clear()
    }

    override fun observeLiveData(): LiveData<List<ItemDBModel>> = itemsDao.observeLiveData()

    override fun observeReceiveChannel(): Flowable<List<ItemDBModel>> = itemsDao.observeCoroutine()
}