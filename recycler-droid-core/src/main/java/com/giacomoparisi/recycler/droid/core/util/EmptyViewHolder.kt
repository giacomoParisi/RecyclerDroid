package com.giacomoparisi.recycler.droid.core.util

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.giacomoparisi.recycler.droid.core.DroidViewHolder

/**
 * @author Giacomo Parisi
 * @param layoutId: The id of the layout to insert
 * @param parent: The parentViewGroup
 *
 * An empty viewHolder that allows to render a layout that does not need any configuration
 */
open class EmptyViewHolder<T : Any>(parent: ViewGroup, @LayoutRes layoutId: Int) : DroidViewHolder<T>(
        parent,
        { layoutInflater, viewGroup, b ->
            layoutInflater.inflate(
                    layoutId,
                    viewGroup,
                    b
            )
        }
) {
    override fun bind(t: T, position: Int) {
    }
}