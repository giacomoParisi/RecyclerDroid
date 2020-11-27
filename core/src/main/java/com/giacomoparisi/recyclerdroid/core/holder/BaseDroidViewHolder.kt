package com.giacomoparisi.recyclerdroid.core.holder

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

abstract class BaseDroidViewHolder<T> internal constructor(
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

    val context: Context get() = itemView.context

    fun getString(@StringRes id: Int): String =
            context.getString(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
            context.getString(id, formatArgs)

    fun getColor(@ColorRes id: Int): Int =
            ContextCompat.getColor(context, id)

    fun <T : View> Int.getView(): T =
            this@BaseDroidViewHolder.itemView.findViewById(this)

}
