package com.giacomoparisi.recyclerdroid.core

import android.view.View
import java.util.*

/**
 * Created by Giacomo Parisi on 07/07/2017.
 * https://github.com/giacomoParisi
 */

/**
 *
 * Class that represent an item for the recyclerView.
 * Every item need to implement this class for the DroidAdapter
 */
abstract class DroidItem {

    /**
     * Return the
     */
    abstract val getViewHolder: (view: View) -> DroidViewHolder<DroidItem>

    /**
     * Return the layout id of the view for this item
     */
    abstract fun getLayoutId(): Int

    /**
     *
     * Return the specific DroidViewHolder.Factory for the item
     */
    fun getItemViewHolder(): DroidViewHolder.Factory =
            DroidViewHolder.Factory(UUID.randomUUID().toString(), getLayoutId(), getViewHolder)
}
