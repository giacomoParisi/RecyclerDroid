package com.giacomoparisi.recyclerdroid.sample.paging

import androidx.paging.PagingSource
import com.giacomoparisi.recyclerdroid.sample.item.SampleItem
import kotlinx.coroutines.delay

class SamplePagingSource : PagingSource<Int, SampleItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SampleItem> =

            try {

                val nextPage = params.key ?: 1
                delay(2000) // simulate api request
                val items = buildItem(nextPage, params.pageSize)

                LoadResult.Page(
                        items,
                        prevKey = if (nextPage == 1) null else nextPage - 1,
                        nextKey = nextPage + 1
                )


            } catch (error: Throwable) {

                LoadResult.Error(error)

            }

}


private fun buildItem(page: Int, pageSize: Int): List<SampleItem> =
        (((page -1) * pageSize)..(pageSize * page)).map { SampleItem(it) }