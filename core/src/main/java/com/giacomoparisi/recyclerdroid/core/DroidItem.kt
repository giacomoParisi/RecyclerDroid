package com.giacomoparisi.recyclerdroid.core

import com.giacomoparisi.recyclerdroid.core.adapter.StableDroidAdapter

interface DroidItem<out P: Any> {

    fun areTheSame(other: DroidItem<Any>): Boolean

    fun haveTheSameContent(other: DroidItem<Any>): Boolean

    fun getPayload(other: DroidItem<Any>): List<P>

}

interface StableDroidItem<P: Any> : DroidItem<P> {

    fun stableId(adapter: StableDroidAdapter, position: Int): Long

}



inline fun <reified T : DroidItem<Any>> DroidItem<Any>.compare(
        compare: (T) -> Boolean
): Boolean =
        when (this) {
            is T -> compare(this)
            else -> false
        }

inline fun <P, reified T : DroidItem<P>> DroidItem<Any>.providePayload(
        payload: (T) -> List<P>
): List<P> =
        when (this) {
            is T -> payload(this)
            else -> emptyList()
        }