package com.giacomoparisi.recyclerdroid.sample.paging

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import com.giacomoparisi.recyclerdroid.core.holder.DroidLoadStateViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.DroidLoadStateViewHolderFactory
import com.giacomoparisi.recyclerdroid.sample.R
import com.giacomoparisi.recyclerdroid.sample.databinding.LoadingErrorItemBinding

class LoadingErrorHolder(
        parent: ViewGroup,
        private val retry: () -> Unit
) : DroidLoadStateViewHolder(
        parent,
        R.layout.loading_error_item
) {

    override fun bind(state: LoadState) {

        val binding = LoadingErrorItemBinding.bind(itemView)

        binding.loadStateRetry.isVisible = state !is LoadState.Loading
        binding.loadStateErrorMessage.isVisible = state !is LoadState.Loading
        binding.loadStateProgress.isVisible = state is LoadState.Loading

        if (state is LoadState.Error) {
            binding.loadStateErrorMessage.text = state.error.localizedMessage
        }

        binding.loadStateRetry.setOnClickListener {
            retry.invoke()
        }

    }

    companion object {

        fun factory(retry: () -> Unit): DroidLoadStateViewHolderFactory =
                DroidLoadStateViewHolderFactory { LoadingErrorHolder(it, retry) }

    }

}