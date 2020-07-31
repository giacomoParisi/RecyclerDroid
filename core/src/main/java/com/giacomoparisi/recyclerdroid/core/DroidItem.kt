package com.giacomoparisi.recyclerdroid.core

interface DroidItem {

    fun areTheSame(other: DroidItem): Boolean

    fun haveTheSameContent(other: DroidItem): Boolean

    fun getPayload(other: DroidItem): List<*>

}

interface StableDroidItem : DroidItem {

    fun stableId(position: Int): Long

}

inline fun <reified T : DroidItem> T.compare(other: DroidItem, compare: (T) -> Boolean): Boolean =
        when (other) {
            is T -> compare(other)
            else -> false
        }