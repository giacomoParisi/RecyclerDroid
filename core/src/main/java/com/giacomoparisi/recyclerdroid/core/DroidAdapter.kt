package com.giacomoparisi.recyclerdroid.core

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Giacomo Parisi on 07/07/2017.
 * https://github.com/giacomoParisi
 */

/**
 *
 * The recyclerView.Adapter that populate the recyclerView with DroidItems
 * and bind them with the data.
 * The adapter support the following features:
 *
 * - Different DroidItem (with different DroidViewHolder.Factory)
 *
 * @param itemList The list of DroidItem for populate the recyclerView
 * @param layoutInflater The layoutInflater reference for layout inflating
 */
open class DroidAdapter(
        private var itemList: List<DroidItem>,
        private val layoutInflater: LayoutInflater)
    : RecyclerView.Adapter<DroidViewHolder<*>>() {

    // Map of the all DroidViewHolder.Factory for the different DroidItems
    private var viewHolderMap: MutableMap<Int, DroidViewHolder.Factory> = mutableMapOf()

    fun getItems() = this.itemList

    fun setItems(items: List<DroidItem>) {
        this.itemList = items
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DroidViewHolder<*>, position: Int) {
        holder.bind(this.itemList[position])
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidViewHolder<*> {
        return viewHolderMap[viewType]!!.create(layoutInflater, parent)
    }

    override fun getItemViewType(position: Int): Int {

        val viewHolderId = this.itemList[position].getItemViewHolder().id

        for ((key, value) in this.viewHolderMap) {
            if (value.id == viewHolderId) {
                return key
            }
        }

        this.viewHolderMap[this.viewHolderMap.size + 1] = this.itemList[position].getItemViewHolder()
        return this.viewHolderMap.size
    }
}
