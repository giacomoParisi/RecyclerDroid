package com.giacomoparisi.recyclerdroid.core.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.LoadState

abstract class DroidLoadStateViewHolder private constructor(
        itemView: View
) : BaseDroidViewHolder<LoadState>(itemView) {

    constructor(parent: ViewGroup, factory: (LayoutInflater, ViewGroup, Boolean) -> View) :
            this(factory(LayoutInflater.from(parent.context), parent, false))

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int) :
            this(
                    parent,
                    { layoutInflater, viewGroup, b ->
                        layoutInflater.inflate(layoutId, viewGroup, b)
                    }
            )

    abstract fun bind(state: LoadState)

}