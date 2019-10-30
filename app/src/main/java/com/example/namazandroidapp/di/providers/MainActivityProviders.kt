package com.example.namazandroidapp.di.providers

import com.example.namazandroidapp.presentation.ui.main.fragments.FirstFragment
import com.example.namazandroidapp.presentation.ui.main.fragments.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun provideSecondFragment(): SecondFragment
}