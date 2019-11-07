package com.giacomoparisi.recycler.droid.core.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable


class RecyclerViewPagingObservable internal constructor(private val view: RecyclerView) : Observable<Int>() {

    private lateinit var listener: Listener

    override fun subscribeActual(observer: Observer<in Int>) {
        this.listener = Listener(view, observer)
        observer.onSubscribe(listener)
        view.addOnScrollListener(listener.scrollListener)
    }

    fun clear() = this.listener.clear()

    internal inner class Listener(private val recyclerView: RecyclerView, observer: Observer<in Int>) : MainThreadDisposable() {
        internal val scrollListener: RecyclerView.OnScrollListener
        private var pastVisibleItems: Int = 0
        private var visibleItemCount: Int = 0
        private var totalItemCount: Int = 0
        internal var counter = 1
        internal var calculatedPage = hashMapOf<Int, Int>()

        init {
            val layoutManager = this.recyclerView.layoutManager
            this.scrollListener = object : RecyclerView.OnScrollListener() {
                @SuppressLint("LogNotTimber")
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    try {
                        totalItemCount = layoutManager!!.itemCount
                        visibleItemCount = layoutManager.childCount
                        when (layoutManager) {
                            is LinearLayoutManager -> pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                            else -> Log.w("RxRecyclerView", "Your layout manager is not appropriate for paging.")
                        }

                    } catch (e: NullPointerException) {
                        throw NullPointerException("Layout manager is null.You should set manager before set observable")
                    }

                    if (!calculatedPage.containsKey(totalItemCount)) {
                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            calculatedPage[totalItemCount] = counter
                            counter++
                            if (!isDisposed) {
                                observer.onNext(counter)
                            }
                        }
                    }
                }
            }
        }

        override fun onDispose() {
            recyclerView.removeOnScrollListener(scrollListener)
        }

        fun clear() {
            this.pastVisibleItems = 0
            this.visibleItemCount = 0
            this.totalItemCount = 0
            this.counter = 1
            this.calculatedPage = hashMapOf()
        }
    }
}

fun RecyclerView.pagingObservable() =
        RecyclerViewPagingObservable(this)