package com.example.namazandroidapp.domain.usercase.blocks

import com.example.namazandroidapp.domain.usercase.BaseObserveCoroutinesUseCase



typealias ObserverBlock<T> = BaseObserveCoroutinesUseCase.Request<T>.() -> Unit