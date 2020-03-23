package com.giacomoparisi.recyclerdroid.core.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

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

        val info = LinearDecoratorInfo(index, childCount)

        with(outRect) {
            this.top = this@LinearMarginItemDecoration.topMargin(info)
            this.left = this@LinearMarginItemDecoration.startMargin(info)
            this.right = this@LinearMarginItemDecoration.endMargin(info)
            this.bottom = this@LinearMarginItemDecoration.bottomMargin(info)
        }
    }
}

data class LinearDecoratorInfo(val index: Int, val itemCount: Int)

