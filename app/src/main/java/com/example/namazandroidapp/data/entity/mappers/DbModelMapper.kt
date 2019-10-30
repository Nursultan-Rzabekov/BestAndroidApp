package com.example.namazandroidapp.data.entity.mappers

import com.example.namazandroidapp.data.entity.db.ItemDBModel
import com.example.namazandroidapp.data.entity.network.ItemResponse
import com.example.namazandroidapp.data.entity.presentation.ItemUIModel


object DbModelMapper {

    fun map(model: ItemResponse): ItemDBModel = ItemDBModel(model.id, model.name)

    fun map(model: ItemUIModel): ItemDBModel = ItemDBModel(model.id, model.name)
}