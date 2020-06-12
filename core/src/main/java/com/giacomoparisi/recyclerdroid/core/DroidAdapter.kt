package com.giacomoparisi.recyclerdroid.core

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Giacomo Parisi on 07/07/2017.
 * https://github.com/giacomoParisi
 */

data class ViewHolderFactory<T: DroidItem>(
        val factory: (ViewGroup) -> DroidViewHolder<T, *>,
        val selector: (Int, T) -> Boolean
)

open class DroidAdapter<T : DroidItem>(
        private vararg val factories: ViewHolderFactory<T>
) : ListAdapter<T, DroidViewHolder<T, *>>(object : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.areTheSame(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.haveTheSameContent(newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? =
            oldItem.getPayload(newItem)
}) {


    override fun getItemViewType(position: Int): Int {
        factories.forEachIndexed { i, factory ->
            if (factory.selector(position, getItem(position)))
                return i
        }

        throw RuntimeException("Error defining default factory")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidViewHolder<T, *> =
            factories[viewType].factory(parent).also { it.adapter = this }

    override fun onBindViewHolder(
            holder: DroidViewHolder<T, *>,
            position: Int
    ) {

        handlePaging(position)

        val item = getItem(position)
        holder.item = item
        holder.bind(item, position)
    }

    override fun onBindViewHolder(
            holder: DroidViewHolder<T, *>,
            position: Int,
            payloads: MutableList<Any>
    ) {

        handlePaging(position)

        val item = getItem(position)
        holder.item = item

        if (payloads.isEmpty())
            holder.bind(item, position)
        else
            holder.bindRawPayload(item, position, payloads)
    }

    fun getItems(): List<T> {

        val list = mutableListOf<T>()
        for (i in 0 until this.itemCount)
            list.add(this.getItem(i))

        return list.toList()
    }

    /* ---- paging ----- */

    var pageListener: (() -> Unit)? = null
    private var lastItemIndex: Int = -1

    private fun handlePaging(position: Int): Unit {

        if (position == getItems().size - 1 && lastItemIndex != position) {
            lastItemIndex = position
            pageListener?.invoke()
        }
    }
}
