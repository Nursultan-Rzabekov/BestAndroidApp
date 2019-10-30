package com.example.namazandroidapp.di.modules

import android.app.Application
import androidx.room.Room
import com.example.namazandroidapp.data.storage.database.AppDatabase
import com.example.namazandroidapp.data.storage.database.dao.IItemsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase = Room
        .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
        .addMigrations()
        .build()

    @Provides
    fun provideItemDao(db: AppDatabase): IItemsDao = db.itemDao()
}