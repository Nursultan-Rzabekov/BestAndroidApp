package com.example.namazandroidapp.domain.usercase.items

import com.example.namazandroidapp.data.entity.mappers.UiModelMapper
import com.example.namazandroidapp.data.entity.presentation.ItemUIModel
import com.example.namazandroidapp.domain.repository.IItemsRepository
import com.example.namazandroidapp.domain.usercase.BaseCoroutinesUseCase
import javax.inject.Inject

/**
 * Created by Alexey Shishov
 * on 25.07.19
 */
class GetItemsUseCase @Inject constructor(
    private val itemsRepository: IItemsRepository
) : BaseCoroutinesUseCase<List<ItemUIModel>>() {

    override suspend fun executeOnBackground(): List<ItemUIModel> =
        itemsRepository.get().map { model -> UiModelMapper.map(model) }
}