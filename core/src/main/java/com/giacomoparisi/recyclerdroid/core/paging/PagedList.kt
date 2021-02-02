package com.giacomoparisi.recyclerdroid.core.paging

class PagedList<out T>(
        val data: List<T>,
        val page: Int,
        val isCompleted: Boolean) {

    val size = data.size
    val lastIndex = data.lastIndex

    fun isEmpty() = data.isEmpty()

    fun <A> map(mapper: (T) -> A) =
            PagedList(data.map { mapper(it) }, page, isCompleted)

    fun <A> mapIndexed(mapper: (Int, T) -> A) =
            PagedList(
                    data.mapIndexed { index, t -> mapper(index, t) },
                    page,
                    isCompleted
            )

    fun <A : Any> mapNotNull(mapper: (T) -> A?) =
            PagedList(data.mapNotNull { mapper(it) }, page, isCompleted)

    fun <A : Any> mapIndexedNotNull(mapper: (Int, T) -> A?) =
            PagedList(
                    data.mapIndexedNotNull { index, t -> mapper(index, t) },
                    page,
                    isCompleted
            )

    fun filter(filter: (T) -> Boolean) = PagedList(
            data.filter(filter),
            page,
            isCompleted
    )

    fun filterIndexed(filter: (Int, T) -> Boolean) = PagedList(
            data.filterIndexed(filter),
            page,
            isCompleted
    )

    inline fun <reified R> filterIsInstance(): PagedList<R> =
            PagedList(data.filterIsInstance<R>(), page, isCompleted)

    companion object {

        /**
         * Create an instance of an empty paged list
         */
        fun <T> empty() = PagedList<T>(emptyList(), -1, false)

    }
}

fun <T> List<T>.toPagedList(page: Int = 0, isCompleted: Boolean = false) =
        PagedList(this, page, isCompleted)

fun <T> PagedList<T>.addPage(other: PagedList<T>) =
        PagedList(data.plus(other.data), other.page, other.isCompleted)