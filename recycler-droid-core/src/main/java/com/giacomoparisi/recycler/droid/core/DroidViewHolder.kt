package com.giacomoparisi.recycler.droid.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    abstract fun bind(t: T)
}
