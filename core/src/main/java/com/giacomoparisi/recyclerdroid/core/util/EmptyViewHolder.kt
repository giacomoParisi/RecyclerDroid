package com.giacomoparisi.recyclerdroid.core.util

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.DroidViewHolder

/**
 * @author Giacomo Parisi
 * @param layoutId: The id of the layout to insert
 * @param parent: The parentViewGroup
 *
 * An empty viewHolder that allows to render a layout that does not need any configuration
 */
open class EmptyViewHolder<T : DroidItem>(
        parent: ViewGroup,
        @LayoutRes layoutId: Int
) : DroidViewHolder<T, Unit>(
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