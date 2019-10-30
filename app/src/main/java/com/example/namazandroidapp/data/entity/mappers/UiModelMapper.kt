package com.example.namazandroidapp.data.entity.mappers

import com.example.namazandroidapp.data.entity.db.ItemDBModel
import com.example.namazandroidapp.data.entity.presentation.ItemUIModel


object UiModelMapper {

    fun map(model: ItemDBModel): ItemUIModel = ItemUIModel(model.id, model.name)
}