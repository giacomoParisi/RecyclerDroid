package com.giacomoparisi.recycler.droid.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Giacomo Parisi on 10/04/17.
 * https://github.com/giacomoParisi
 */

abstract class DroidViewHolder<T : Any>
private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup, factory: (LayoutInflater, ViewGroup, Boolean) -> View) :
            this(factory(LayoutInflater.from(parent.context), parent, false))

    lateinit var item: T

    abstract fun bind(t: T, position: Int)

    val context: Context get() = this.itemView.context

    fun getString(@StringRes id: Int) =
            this.context.getString(id)

    fun getColor(@ColorRes id: Int) =
            ContextCompat.getColor(this.context, id)

    fun <T : View> Int.getView() =
            this@DroidViewHolder.itemView.findViewById<T>(this)
}
