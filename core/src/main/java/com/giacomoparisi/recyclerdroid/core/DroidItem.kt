package com.giacomoparisi.recyclerdroid.core

interface DroidItem {

    fun areTheSame(other: DroidItem): Boolean

    fun haveTheSameContent(other: DroidItem): Boolean

    fun getPayload(other: DroidItem): List<*>

}

interface StableDroidItem : DroidItem {

    fun stableId(position: Int): Long

}

inline fun <reified T : DroidItem> DroidItem.compare(compare: (T) -> Boolean): Boolean =
        when (this) {
            is T -> compare(this)
            else -> false
        }

inline fun <reified T : DroidItem, P> DroidItem.providePayload(payload: (T) -> List<P>): List<P> =
        when (this) {
            is T -> payload(this)
            else -> emptyList()
        }