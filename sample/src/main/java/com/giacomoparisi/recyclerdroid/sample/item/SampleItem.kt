package com.giacomoparisi.recyclerdroid.sample.item

import android.view.ViewGroup
import android.widget.TextView
import com.giacomoparisi.recyclerdroid.core.DroidItem
import com.giacomoparisi.recyclerdroid.core.compare
import com.giacomoparisi.recyclerdroid.core.holder.DroidViewHolder
import com.giacomoparisi.recyclerdroid.core.holder.ViewHolderFactory
import com.giacomoparisi.recyclerdroid.core.holder.typeCheckViewHolderFactory
import com.giacomoparisi.recyclerdroid.sample.R

data class SampleItem(val number: Int) : DroidItem<Unit> {

    override fun areTheSame(other: DroidItem<Any>): Boolean =
            compare<SampleItem> { it == it }

    override fun haveTheSameContent(other: DroidItem<Any>): Boolean =
            compare<SampleItem> { it == it }

    override fun getPayload(other: DroidItem<Any>): List<Unit> = emptyList()

}

class SampleViewHolder(
        parent: ViewGroup
) : DroidViewHolder<SampleItem, Unit>(parent, R.layout.item) {

    override fun bind(t: SampleItem, position: Int) {

        itemView.findViewById<TextView>(R.id.text_item).text = t.number.toString()

    }

    companion object {

        fun factory(): ViewHolderFactory =
                typeCheckViewHolderFactory<SampleItem> { SampleViewHolder(it) }

    }

}