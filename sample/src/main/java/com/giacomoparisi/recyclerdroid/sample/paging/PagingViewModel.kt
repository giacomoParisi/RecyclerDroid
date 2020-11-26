package com.giacomoparisi.recyclerdroid.sample.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.giacomoparisi.recyclerdroid.sample.item.SampleItem
import kotlinx.coroutines.flow.Flow

class PagingViewModel : ViewModel() {

    val items: Flow<PagingData<SampleItem>> =
            Pager(PagingConfig(pageSize = 20)) { SamplePagingSource() }.flow
                    .cachedIn(viewModelScope)

}