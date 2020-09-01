package com.giacomoparisi.recyclerdroid.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Giacomo Parisi on 10/04/17.
 * https://github.com/giacomoParisi
 */

abstract class DroidViewHolder<T : DroidItem<P>, P: Any> private constructor(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {

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
    lateinit var adapter: DroidAdapter

    abstract fun bind(t: T, position: Int)

    @Suppress("UNCHECKED_CAST")
    fun bindRawPayload(t: T, position: Int, payloads: List<Any>) {

        val payloadObjects = payloads.flatMap { (it as? List<P>).orEmpty() }

        if (payloadObjects.isEmpty())
            bind(t, position)
        else
            bind(t, position, payloadObjects)
    }

    open fun bind(t: T, position: Int, payloads: List<P>) {}

    val context: Context get() = itemView.context

    fun getString(@StringRes id: Int): String =
            context.getString(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
            context.getString(id, formatArgs)

    fun getColor(@ColorRes id: Int) =
            ContextCompat.getColor(context, id)

    fun <T : View> Int.getView(): T =
            this@DroidViewHolder.itemView.findViewById(this)

    fun getItems() = adapter.getItems()

    fun getListSize() = getItems().count()
}
