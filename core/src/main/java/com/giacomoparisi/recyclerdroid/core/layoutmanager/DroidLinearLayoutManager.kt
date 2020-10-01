package com.giacomoparisi.recyclerdroid.core.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

open class DroidLinearLayoutManager : LinearLayoutManager {

    private val supportsPredictiveItemAnimations: Boolean
    private val context: Context

    constructor(
            context: Context,
            supportsPredictiveItemAnimations: Boolean = true
    ) : super(context) {
        this.context = context
        this.supportsPredictiveItemAnimations = supportsPredictiveItemAnimations
    }

    constructor(
            context: Context,
            orientation: Int,
            reverseLayout: Boolean,
            supportsPredictiveItemAnimations: Boolean = true
    ) : super(
            context,
            orientation,
            reverseLayout
    ) {
        this.context = context
        this.supportsPredictiveItemAnimations = supportsPredictiveItemAnimations
    }

    override fun supportsPredictiveItemAnimations(): Boolean = supportsPredictiveItemAnimations
}