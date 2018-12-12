package com.giacomoparisi.recycler.droid.core

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Giacomo Parisi on 07/07/2017.
 * https://github.com/giacomoParisi
 */

typealias ViewHolderFactory<T> = (ViewGroup) -> DroidViewHolder<T>

open class DroidAdapter<T : Any>(
        defaultFactory: ViewHolderFactory<out T>,
        areItemsTheSame: (T, T) -> Boolean,
        areContentsTheSame: (T, T) -> Boolean,
        getChangePayload: (T, T) -> Any? = { _, _ -> null }
) : ListAdapter<T, DroidViewHolder<T>>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = areItemsTheSame(oldItem, newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = areContentsTheSame(oldItem, newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? = getChangePayload(oldItem, newItem)
}) {

    private val factories = mutableListOf({ _: Int, _: T -> true } to defaultFactory)

    override fun getItemViewType(position: Int): Int {
        factories.forEachIndexed { i, pair ->
            if (pair.first(position, getItem(position))) {
                return i
            }
        }

        throw RuntimeException("Error defining default factory")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidViewHolder<T> = factories[viewType].second(parent) as DroidViewHolder<T>

    override fun onBindViewHolder(holder: DroidViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.item = item
        holder.bind(item)
    }

    override fun onBindViewHolder(holder: DroidViewHolder<T>, position: Int, payloads: MutableList<Any>) {
        val item = getItem(position)
        holder.item = item
        holder.bind(item)
    }

    fun addItemType(selector: (Int, T) -> Boolean, factory: ViewHolderFactory<out T>) = apply {
        factories.add(factories.size - 1, selector to factory)
    }

    inline fun <reified S : T> addItemType(noinline factory: ViewHolderFactory<S>) = apply {
        addItemType({ _: Int, item: T -> item is S }, factory)
    }

    fun getItems(): List<T> {
        val list = mutableListOf<T>()
        for (i in 0..(this.itemCount - 1)) {
            list.add(this.getItem(i))
        }
        return list.toList()
    }
}