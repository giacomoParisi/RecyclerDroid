package com.giacomoparisi.recycler.droid.core

sealed class DroidAdapterEvent {

    object FirstItemCreated: DroidAdapterEvent()
    data class ItemCreated(val position: Int): DroidAdapterEvent()
    object LastItemCreated: DroidAdapterEvent()
}