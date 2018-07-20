package com.giacomoparisi.recyclerdroid.core

/**
 * Created by Giacomo Parisi on 20/07/18.
 * https://github.com/giacomoParisi
 */
data class DroidAction<D : DroidItem>(val from: D, val action: DroidActionType)