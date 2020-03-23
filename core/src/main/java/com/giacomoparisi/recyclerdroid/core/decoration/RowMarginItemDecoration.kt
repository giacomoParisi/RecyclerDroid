package com.giacomoparisi.recyclerdroid.core.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RowMarginItemDecoration(
        private val rowCount: Int,
        private val topMargin: (GridDecoratorInfo) -> Int = { 0 },
        private val startMargin: (GridDecoratorInfo) -> Int = { 0 },
        private val endMargin: (GridDecoratorInfo) -> Int = { 0 },
        private val bottomMargin: (GridDecoratorInfo) -> Int = { 0 }
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {

        val index = parent.getChildAdapterPosition(view)
        val childCount = parent.adapter?.itemCount ?: 0
        val rowItemCount = childCount / this.rowCount
        val rowIndex = this.getItemRow(index)
        val itemRowIndex = index / this.rowCount

        val info = GridDecoratorInfo(index, childCount, rowIndex, itemRowIndex, rowItemCount)

        with(outRect) {
            this.top = this@RowMarginItemDecoration.topMargin(info)
            this.left = this@RowMarginItemDecoration.startMargin(info)
            this.right = this@RowMarginItemDecoration.endMargin(info)
            this.bottom = this@RowMarginItemDecoration.bottomMargin(info)
        }
    }

    private fun getItemRow(index: Int) =
            (this.rowCount - ((index + 1) % this.rowCount))
}

data class GridDecoratorInfo(val index: Int, val itemCount: Int, val rowIndex: Int, val itemRowIndex: Int, val rowItemCount: Int)

