package com.brando.chowjetzt.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brando.search.ui.PhotosAdapter

object AdapterBindings {
    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, locationAdapter: PhotosAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = locationAdapter
    }
}
