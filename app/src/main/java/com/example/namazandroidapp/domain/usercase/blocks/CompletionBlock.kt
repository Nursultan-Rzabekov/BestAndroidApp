package com.example.namazandroidapp.domain.usercase.blocks

import com.example.namazandroidapp.domain.usercase.BaseCoroutinesUseCase



typealias CompletionBlock<T> = BaseCoroutinesUseCase.Request<T>.() -> Unit