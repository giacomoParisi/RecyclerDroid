package com.giacomoparisi.recyclerdroid.core.holder

import android.view.ViewGroup
import com.giacomoparisi.recyclerdroid.core.DroidItem

open class ViewHolderFactory(
        val factory: (ViewGroup) -> DroidViewHolder<out DroidItem<Any>, out Any>,
        val selector: (Int, DroidItem<Any>) -> Boolean
)

inline fun <reified T> typeCheckViewHolderFactory(
        noinline factory: (ViewGroup) -> DroidViewHolder<out DroidItem<Any>, out Any>
): ViewHolderFactory =
        ViewHolderFactory(
                factory,
                { _, droidItem -> droidItem is T }
        )
