package com.giacomoparisi.recyclerdroid.core

interface DroidItem {

    fun areTheSame(other: DroidItem): Boolean

    fun haveTheSameContent(other: DroidItem): Boolean

    fun getPayload(other: DroidItem): List<*>

}

interface StableDroidItem: DroidItem {

    fun stableId(position: Int): Long

}