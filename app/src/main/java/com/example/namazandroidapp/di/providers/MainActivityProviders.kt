package com.example.namazandroidapp.di.providers

import com.example.namazandroidapp.presentation.ui.main.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun providePageFragment(): PageFragment

    @ContributesAndroidInjector
    abstract fun provideLocationFragment(): LocationFragment

    @ContributesAndroidInjector
    abstract fun provideTimeFragment(): TimeFragment

    @ContributesAndroidInjector
    abstract fun provideMosquesFragment(): MosquesFragment

    @ContributesAndroidInjector
    abstract fun provideFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun provideSecondFragment(): SecondFragment
}