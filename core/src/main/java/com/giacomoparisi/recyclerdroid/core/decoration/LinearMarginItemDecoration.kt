package com.giacomoparisi.recyclerdroid.core.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giacomoparisi.recyclerdroid.core.DroidAdapter
import com.giacomoparisi.recyclerdroid.core.DroidItem

class LinearMarginItemDecoration(
        private val topMargin: (LinearDecoratorInfo) -> Int = { 0 },
        private val startMargin: (LinearDecoratorInfo) -> Int = { 0 },
        private val endMargin: (LinearDecoratorInfo) -> Int = { 0 },
        private val bottomMargin: (LinearDecoratorInfo) -> Int = { 0 }
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {

        val index = parent.getChildAdapterPosition(view)
        val childCount = parent.adapter?.itemCount ?: 0

        val info =
                LinearDecoratorInfo(
                        index,
                        childCount,
                        (parent.adapter as DroidAdapter).getItems()[index]
                )

        with(outRect) {
            top = topMargin(info)
            left = startMargin(info)
            right = endMargin(info)
            bottom = bottomMargin(info)
        }
    }
}

data class LinearDecoratorInfo(val index: Int, val itemCount: Int, val item: DroidItem<Any>) {

    fun isFirst(trueMargin: Int, falseMargin: Int): Int =
            if (index == 0) trueMargin else falseMargin

    fun isFirst(): Boolean = index == 0

    fun isLast(): Boolean = index == (itemCount - 1)

    fun isLast(trueMargin: Int, falseMargin: Int): Int =
            if (index == (itemCount - 1)) trueMargin else falseMargin

    inline fun <reified T : DroidItem<Any>> isOfType(trueMargin: Int, falseMargin: Int): Int =
            if (item is T) trueMargin else falseMargin

    inline fun <reified T : DroidItem<Any>> isOfType(): Boolean = item is T

}

