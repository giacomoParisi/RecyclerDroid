package com.giacomoparisi.recyclerdroid.core.adapter

import com.giacomoparisi.recyclerdroid.core.StableDroidItem
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolderFactory

open class StableDroidAdapter(
        vararg factories: DroidViewHolderFactory
) : DroidAdapter(*factories) {

    init {

        this.setHasStableIds(true)

    }

    override fun getItemId(position: Int): Long =
            (getItems()[position] as? StableDroidItem)
                    ?.stableId(this, position) ?: position.hashCode().toLong()

}