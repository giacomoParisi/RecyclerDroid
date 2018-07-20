package com.giacomoparisi.recyclerdroid.core

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject

/**
 * Created by Giacomo Parisi on 10/04/17.
 * https://github.com/giacomoParisi
 */

/**
 *
 * RecyclerView ViewHolder that support the DroidBox architecture
 */
abstract class DroidViewHolder<D : DroidItem>(view: View) : RecyclerView.ViewHolder(view) {

    // The droid item that this viewHolder bind
    var data: D? = null

    lateinit var observer: PublishSubject<DroidAction<*>>

    /**
     *
     * Bind the viewHolder with the specific data of an DroidItem
     *
     * @param data The droidItem to bind with the viewHolder
     */
    @Suppress("UNCHECKED_CAST")
    open fun bind(data: DroidItem) {
        try {
            this.data = data as D
        } catch (exception: RuntimeException) {
        }
    }


    /**
     *
     * Factory class to setup the DroidViewHolder
     *
     * @param layoutId The layout id of the view that the viewHolder menage
     * @param factory The ViewHolderFactory to build the viewHolder
     */
    class Factory(
            val id: String,
            private val layoutId: Int,
            private val factory: (v: View) -> DroidViewHolder<*>) {

        fun create(inflater: LayoutInflater, parent: ViewGroup): DroidViewHolder<*> {
            val view = inflater.inflate(layoutId, parent, false)
            return factory(view)
        }
    }
}
