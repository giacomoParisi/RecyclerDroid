package com.giacomoparisi.recyclerdroid.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolderFactory
import com.giacomoparisi.recyclerdroid.core.paging.PagedList

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

    private var items: PagedList<DroidItem<Any>>? = null

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

    override fun getItems(): List<DroidItem<Any>> = items?.data ?: emptyList()

    fun getPagedItems(): PagedList<DroidItem<Any>> = items ?: PagedList.empty()

    override fun submitList(list: MutableList<DroidItem<Any>>?) {
        items = list?.let { PagedList(it, 0, true) }
        super.submitList(list)
    }

    fun submitPagedList(list: PagedList<DroidItem<Any>>?) {
        items = list
        super.submitList(list?.data)
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
