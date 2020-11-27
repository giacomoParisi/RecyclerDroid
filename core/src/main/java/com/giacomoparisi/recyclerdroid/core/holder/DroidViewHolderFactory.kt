package com.giacomoparisi.recyclerdroid.core.holder

import android.view.ViewGroup
import com.giacomoparisi.recyclerdroid.core.DroidItem

open class DroidViewHolderFactory(
        val factory: (ViewGroup) -> DroidViewHolder<out DroidItem<Any>, out Any>,
        val selector: (Int, DroidItem<Any>) -> Boolean
)

inline fun <reified T> typeCheckDroidViewHolderFactory(
        noinline factory: (ViewGroup) -> DroidViewHolder<out DroidItem<Any>, out Any>
): DroidViewHolderFactory =
        DroidViewHolderFactory(
                factory,
                { _, droidItem -> droidItem is T }
        )

open class DroidLoadStateViewHolderFactory(val factory: (ViewGroup) -> DroidLoadStateViewHolder)
