package com.giacomoparisi.recyclerdroid.core.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.giacomoparisi.recyclerdroid.core.holder.DroidLoadStateViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.DroidLoadStateViewHolderFactory

class DroidLoadStateAdapter(
        private val factory: DroidLoadStateViewHolderFactory
) : LoadStateAdapter<DroidLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: DroidLoadStateViewHolder, loadState: LoadState) {

        holder.bind(loadState)

    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            loadState: LoadState
    ): DroidLoadStateViewHolder =
            factory.factory(parent)


}