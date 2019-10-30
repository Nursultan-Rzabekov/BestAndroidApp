package com.example.namazandroidapp.domain.usercase.items

import com.example.namazandroidapp.data.entity.mappers.UiModelMapper
import com.example.namazandroidapp.data.entity.presentation.ItemUIModel
import com.example.namazandroidapp.domain.repository.IItemsRepository
import com.example.namazandroidapp.domain.usercase.BaseObserveCoroutinesUseCase
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription
import javax.inject.Inject

/**
 * Created by Alexey Shishov
 * on 25.07.19
 */
class ObserveChannelItemsUseCase @Inject constructor(
    private val itemsRepository: IItemsRepository
) : BaseObserveCoroutinesUseCase<List<ItemUIModel>>() {

    override fun observe(): ReceiveChannel<List<ItemUIModel>> =
        itemsRepository.observeReceiveChannel().map { list -> list.map { UiModelMapper.map(it) } }.openSubscription()
}

