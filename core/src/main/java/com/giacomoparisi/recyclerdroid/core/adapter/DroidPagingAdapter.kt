package com.giacomoparisi.recyclerdroid.core.adapter

import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolderFactory

open class DroidPagingAdapter(
        private vararg val factories: DroidViewHolderFactory
) : PagingDataAdapter<DroidItem<Any>, DroidViewHolder<DroidItem<Any>, Any>>(
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
            getItem(position)?.let {
                if (factory.selector(position, it))
                    return i
            }
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

        val item = getItem(position)

        item?.let {
            holder.item = it
            holder.bind(it, position)
        }

    }

    override fun onBindViewHolder(
            holder: DroidViewHolder<DroidItem<Any>, Any>,
            position: Int,
            payloads: MutableList<Any>
    ) {

        val item = getItem(position)

        item?.let {

            holder.item = it

            if (payloads.isEmpty())
                holder.bind(it, position)
            else
                holder.bindRawPayload(it, position, payloads)

        }
    }

    override fun getItems(): List<DroidItem<Any>> {

        val list = mutableListOf<DroidItem<Any>>()
        for (i in 0 until this.itemCount)
            getItem(i)?.let { list.add(it) }

        return list.toList()
    }

    @Suppress("UNCHECKED_CAST")
    suspend fun <T : DroidItem<Any>> submitDroidItems(data: PagingData<T>): Unit =
            submitData(data as PagingData<DroidItem<Any>>)

}