package com.giacomoparisi.recyclerdroid.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolderFactory

/**
 * Created by Giacomo Parisi on 07/07/2017.
 * https://github.com/giacomoParisi
 */

open class DroidAdapter(
        private vararg val factories: DroidViewHolderFactory
) : ListAdapter<DroidItem<Any>, DroidViewHolder<DroidItem<Any>, Any>>(
        object : DiffUtil.ItemCallback<DroidItem<Any>>() {

            override fun areItemsTheSame(
                    oldItem: DroidItem<Any>,
                    newItem: DroidItem<Any>
            ): Boolean =
                    oldItem.areTheSame(newItem)

            override fun areContentsTheSame(
                    oldItem: DroidItem<Any>,
                    newItem: DroidItem<Any>
            ): Boolean =
                    oldItem.haveTheSameContent(newItem)

            override fun getChangePayload(
                    oldItem: DroidItem<Any>,
                    newItem: DroidItem<Any>
            ): Any =
                    oldItem.getPayload(newItem)
        }
), IDroidAdapter {

    override fun getItemViewType(position: Int): Int {
        factories.forEachIndexed { i, factory ->
            if (factory.selector(position, getItem(position)))
                return i
        }

        throw RuntimeException("Error defining default factory")
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): DroidViewHolder<DroidItem<Any>, Any> =
            (factories[viewType].factory(parent) as DroidViewHolder<DroidItem<Any>, Any>)
                    .also { it.adapter = this }

    override fun onBindViewHolder(
            holder: DroidViewHolder<DroidItem<Any>, Any>,
            position: Int
    ) {

        handlePaging(position)

        val item = getItem(position)
        holder.item = item
        holder.bind(item, position)
    }

    override fun onBindViewHolder(
            holder: DroidViewHolder<DroidItem<Any>, Any>,
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

    override fun getItems(): List<DroidItem<Any>> {

        val list = mutableListOf<DroidItem<Any>>()
        for (i in 0 until itemCount)
            list.add(getItem(i))

        return list.toList()
    }

    /* ---- paging ----- */

    var pageListener: (() -> Unit)? = null
    private var lastItemIndex: Int = -1

    private fun handlePaging(position: Int) {

        if (position == getItems().size - 1 && lastItemIndex != position) {
            lastItemIndex = position
            pageListener?.invoke()
        }
    }
}
