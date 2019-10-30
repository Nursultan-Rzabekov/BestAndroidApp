package com.example.namazandroidapp.di.modules

import com.example.namazandroidapp.di.providers.MainActivityProviders
import com.example.namazandroidapp.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}