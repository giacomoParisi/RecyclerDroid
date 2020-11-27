package com.giacomoparisi.recyclerdroid.sample.paging

import androidx.paging.PagingSource
import com.giacomoparisi.recyclerdroid.sample.item.SampleItem
import kotlinx.coroutines.delay
import kotlin.random.Random

class SamplePagingSource : PagingSource<Int, SampleItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SampleItem> =

            try {

                val nextPage = params.key ?: 1
                delay(2000) // simulate api request
                val items = buildItem(nextPage, params.loadSize)

                LoadResult.Page(
                        items,
                        prevKey = if (nextPage == 1) null else nextPage - 1,
                        nextKey = if (nextPage >= 5) null else nextPage + 1 // load 5
                )


            } catch (error: Throwable) {

                LoadResult.Error(error)

            }

}


private fun buildItem(page: Int, pageSize: Int): List<SampleItem> {

    val random = Random.nextInt(0, 10) // simulate random error
    if (random % 2 == 0) throw Exception("Ops an error has occurred")

    return (((page - 1) * pageSize)..(pageSize * page)).map { SampleItem(it) }

}