package com.example.namazandroidapp.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.namazandroidapp.data.entity.db.ItemDBModel
import com.example.namazandroidapp.data.storage.database.dao.IItemsDao


@Database(
    version = AppDatabase.VERSION,
    exportSchema = false,
    entities = [ItemDBModel::class]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "project_db_name.db" //TODO: Change db name
        const val VERSION = 1
    }

    abstract fun itemDao(): IItemsDao
}