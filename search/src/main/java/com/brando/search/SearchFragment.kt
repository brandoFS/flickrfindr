package com.brando.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    private lateinit var listener: OnImageSelected

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchButton()
    }

    private fun setupSearchButton() {
        btn_search.setOnClickListener {
            Toast.makeText(activity, "Hello test!", Toast.LENGTH_LONG).show()
            listener.onImageSelected(1)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnImageSelected) {
            listener = context
        } else {
            throw ClassCastException(
                context.toString() + " must implement OnDogSelected.")
        }
    }

    interface OnImageSelected {
        fun onImageSelected(id : Int)
    }


}