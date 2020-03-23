package com.giacomoparisi.recyclerdroid.core.paging

class PagedList<T>(
        val data: List<T>,
        val page: Int,
        val isCompleted: Boolean) {

    val size = data.size
    val lastIndex = data.lastIndex

    fun isEmpty() = data.isEmpty()

    fun <A> map(mapper: (T) -> A) =
            PagedList(data.map { mapper(it) }, this.page, this.isCompleted)

    fun <A> map(mapper: (Int, T) -> A) =
            PagedList(data.mapIndexed { index, t -> mapper(index, t) }, this.page, this.isCompleted)

    fun <A : Any> mapNotNull(mapper: (T) -> A?) =
            PagedList(data.mapNotNull { mapper(it) }, this.page, this.isCompleted)

    fun <A : Any> mapNotNull(mapper: (Int, T) -> A?) =
            PagedList(data.mapIndexedNotNull { index, t -> mapper(index, t) }, this.page, this.isCompleted)

    fun filter(filter: (T) -> Boolean) = PagedList(this.data.filter(filter), this.page, this.isCompleted)

    fun filterIndexed(filter: (Int, T) -> Boolean) = PagedList(this.data.filterIndexed(filter), this.page, this.isCompleted)

    fun addPage(other: PagedList<T>) =
            PagedList(this.data.plus(other.data), other.page, other.isCompleted)

    companion object {

        /**
         * Create an instance of an empty paged list
         */
        fun <T> empty() = PagedList<T>(emptyList(), -1, false)
    }
}

fun <T> List<T>.toPagedList(page: Int = 0, isCompleted: Boolean = false) =
        PagedList(this, page, isCompleted)