package com.brando.imageviewer.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object ImageLoadingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.getContext()
        Glide.with(context).load(url).into(imageView)
    }
}

