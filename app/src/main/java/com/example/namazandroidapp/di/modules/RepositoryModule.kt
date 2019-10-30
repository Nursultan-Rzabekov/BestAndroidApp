package com.example.namazandroidapp.di.modules

import com.example.namazandroidapp.data.repository.ItemsRepository
import com.example.namazandroidapp.domain.repository.IItemsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsItemsRepository(repository: ItemsRepository): IItemsRepository
}