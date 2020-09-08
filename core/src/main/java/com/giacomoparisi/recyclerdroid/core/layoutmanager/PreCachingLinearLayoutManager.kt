package com.giacomoparisi.recyclerdroid.core.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class PreCachingLinearLayoutManager : LinearLayoutManager {

    private val extraLayoutSpace: Int
    private val supportsPredictiveItemAnimations: Boolean
    private val context: Context

    constructor(
            context: Context,
            extraLayoutSpace: Int,
            supportsPredictiveItemAnimations: Boolean
    ) : super(context) {
        this.context = context
        this.extraLayoutSpace = extraLayoutSpace
        this.supportsPredictiveItemAnimations = supportsPredictiveItemAnimations
    }
    constructor(
            context: Context,
            orientation: Int,
            reverseLayout: Boolean,
            extraLayoutSpace: Int,
            supportsPredictiveItemAnimations: Boolean
    ) : super(
            context,
            orientation,
            reverseLayout
    ) {
        this.context = context
        this.extraLayoutSpace = extraLayoutSpace
        this.supportsPredictiveItemAnimations = supportsPredictiveItemAnimations
    }

    override fun getExtraLayoutSpace(state: RecyclerView.State): Int = extraLayoutSpace

    override fun supportsPredictiveItemAnimations(): Boolean = supportsPredictiveItemAnimations
}