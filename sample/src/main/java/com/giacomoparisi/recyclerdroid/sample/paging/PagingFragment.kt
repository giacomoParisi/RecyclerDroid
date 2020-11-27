package com.giacomoparisi.recyclerdroid.sample.paging

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giacomoparisi.recyclerdroid.core.adapter.DroidLoadStateAdapter
import com.giacomoparisi.recyclerdroid.core.adapter.DroidPagingAdapter
import com.giacomoparisi.recyclerdroid.sample.R
import com.giacomoparisi.recyclerdroid.sample.databinding.PagingBinding
import com.giacomoparisi.recyclerdroid.sample.item.SampleViewHolder
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PagingFragment : Fragment(R.layout.paging) {

    private val viewModel: PagingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = PagingBinding.bind(view)

        setupRecyclerView(binding)

    }

    private fun setupRecyclerView(binding: PagingBinding): Unit {

        val droidAdapter = DroidPagingAdapter(SampleViewHolder.factory())

        binding.recyclerView.apply {

            layoutManager =
                    LinearLayoutManager(
                            requireContext(),
                            RecyclerView.VERTICAL,
                            false
                    )
            adapter = droidAdapter.withLoadStateFooter(
                    DroidLoadStateAdapter(LoadingErrorHolder.factory { droidAdapter.retry() })
            )

        }

        lifecycleScope.launch {

            viewModel.items.collectLatest { droidAdapter.submitDroidItems(it) }

        }

    }

}