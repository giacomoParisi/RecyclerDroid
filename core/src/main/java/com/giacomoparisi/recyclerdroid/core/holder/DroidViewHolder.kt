package com.giacomoparisi.recyclerdroid.core.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.adapter.IDroidAdapter

/**
 * Created by Giacomo Parisi on 10/04/17.
 * https://github.com/giacomoParisi
 */

abstract class DroidViewHolder<T : DroidItem<P>, P : Any> private constructor(
        itemView: View
) : BaseDroidViewHolder<T>(itemView) {

    constructor(parent: ViewGroup, factory: (LayoutInflater, ViewGroup, Boolean) -> View) :
            this(factory(LayoutInflater.from(parent.context), parent, false))

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int) :
            this(
                    parent,
                    { layoutInflater, viewGroup, b ->
                        layoutInflater.inflate(layoutId, viewGroup, b)
                    }
            )

    lateinit var item: T
    lateinit var adapter: IDroidAdapter

    abstract fun bind(item: T, position: Int)

    @Suppress("UNCHECKED_CAST")
    fun bindRawPayload(item: T, position: Int, payloads: List<Any>): Unit {

        val payloadObjects = payloads.flatMap { (it as? List<P>).orEmpty() }

        if (payloadObjects.isEmpty())
            bind(item, position)
        else
            bind(item, position, payloadObjects)
    }

    open fun bind(item: T, position: Int, payloads: List<P>): Unit = Unit

    fun getItems(): List<DroidItem<Any>> = adapter.getItems()

    fun getListSize(): Int = getItems().count()
}
