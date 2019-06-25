package com.brando.imageviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ImageFragment : Fragment() {

    companion object {
        private const val EXTRA_IMAGE_ID = "image_id"

        fun createBundle(questionId: Long) =
            Bundle().apply {
                putLong(EXTRA_IMAGE_ID, questionId)
            }
    }

    private val questionId: Long by lazy {
        arguments?.getLong(EXTRA_IMAGE_ID) ?: throw IllegalStateException("no questionId")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image, container, false)
    }
}