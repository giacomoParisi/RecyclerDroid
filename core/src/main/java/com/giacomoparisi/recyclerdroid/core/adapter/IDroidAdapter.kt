package com.giacomoparisi.recyclerdroid.core.adapter

import com.giacomoparisi.recyclerdroid.core.DroidItem

interface IDroidAdapter {

    fun getItems(): List<DroidItem<Any>>

}