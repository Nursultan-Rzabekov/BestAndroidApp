package com.example.namazandroidapp.data.storage.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.namazandroidapp.data.entity.db.ItemDBModel
import io.reactivex.Flowable


@Dao
interface IItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: ItemDBModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<ItemDBModel>)

    @Update
    suspend fun update(model: ItemDBModel)

    @Delete
    suspend fun delete(model: ItemDBModel)

    @Query("DELETE FROM items")
    suspend fun clear()

    @Query("SELECT * FROM items ORDER BY name")
    suspend fun select(): List<ItemDBModel>

    @Query("SELECT * FROM items WHERE id = :id")
    suspend fun getById(id: Int): ItemDBModel

    @Query("SELECT * FROM items ORDER BY name")
    fun observeLiveData(): LiveData<List<ItemDBModel>>

    @Query("SELECT * FROM items ORDER BY name")
    fun observeCoroutine(): Flowable<List<ItemDBModel>>
}