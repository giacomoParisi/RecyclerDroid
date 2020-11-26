package com.giacomoparisi.recyclerdroid.sample.paging

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giacomoparisi.recyclerdroid.core.DroidAdapter
import com.giacomoparisi.recyclerdroid.sample.R
import com.giacomoparisi.recyclerdroid.sample.databinding.PagingBinding
import com.giacomoparisi.recyclerdroid.sample.item.SampleItem
import com.giacomoparisi.recyclerdroid.sample.item.SampleViewHolder

class PagingFragment : Fragment(R.layout.paging) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = PagingBinding.bind(view)

        setupRecyclerView(binding)

    }

    private fun setupRecyclerView(binding: PagingBinding): Unit {

        val droidAdapter = DroidAdapter(SampleViewHolder.factory())

        binding.recyclerView.apply {

            layoutManager =
                    LinearLayoutManager(
                            requireContext(),
                            RecyclerView.VERTICAL,
                            false
                    )
            adapter = droidAdapter

        }

        droidAdapter.submitList(buildItem(10))

    }

    private fun buildItem(count: Int): List<SampleItem> =
            (1..count).map { SampleItem(it) }

}