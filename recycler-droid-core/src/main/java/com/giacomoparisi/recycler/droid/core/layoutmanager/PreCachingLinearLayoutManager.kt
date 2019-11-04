package com.giacomoparisi.recycler.droid.core.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PreCachingLinearLayoutManager : LinearLayoutManager {
    private var extraLayoutSpace: Int
    private var context: Context? = null

    constructor(context: Context, extraLayoutSpace: Int) : super(context) {
        this.context = context
        this.extraLayoutSpace = extraLayoutSpace
    }
    constructor(context: Context, orientation: Int, reverseLayout: Boolean, extraLayoutSpace: Int) : super(
            context,
            orientation,
            reverseLayout
    ) {
        this.context = context
        this.extraLayoutSpace = extraLayoutSpace
    }
    fun setExtraLayoutSpace(extraLayoutSpace: Int) {
        this.extraLayoutSpace = extraLayoutSpace
    }
    override fun getExtraLayoutSpace(state: RecyclerView.State): Int = extraLayoutSpace
}