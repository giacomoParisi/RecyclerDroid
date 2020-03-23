package com.giacomoparisi.recyclerdroid.core.adapter

import com.giacomoparisi.recyclerdroid.core.DroidAdapter
import com.giacomoparisi.recyclerdroid.core.ViewHolderFactory

class StableDroidAdapter<T : Any>(
        val getId: (StableDroidAdapter<T>, Int) -> Long,
        defaultFactory: ViewHolderFactory<out T>,
        areItemsTheSame: (T, T) -> Boolean,
        areContentsTheSame: (T, T) -> Boolean,
        getChangePayload: (T, T) -> Any? = { _, _ -> null }
) : DroidAdapter<T>(defaultFactory, areItemsTheSame, areContentsTheSame, getChangePayload) {


    init {
        this.setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return this.getId(this, position)
    }
}