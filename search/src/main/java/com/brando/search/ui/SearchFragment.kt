package com.brando.search.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brando.search.R
import com.brando.search.databinding.FragmentSearchBinding
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    private lateinit var listener: OnImageSelected
    private lateinit var viewDataBinding : FragmentSearchBinding

    //@Inject
    lateinit var viewModel: SearchViewModel

    //@Inject
    //lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        viewDataBinding = FragmentSearchBinding.bind(view).apply {}
        viewDataBinding.setLifecycleOwner(this.viewLifecycleOwner)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchButton()

        viewModel = ViewModelProviders.of(this, SearchViewModelFactory()).get(SearchViewModel::class.java)
        viewModel.searchFor("dog")
        viewModel.searchResults.observe(this, Observer { feedUiModel ->
            if (feedUiModel.items.isNotEmpty()) {
                Toast.makeText(activity, "Not EMpty!", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(activity, "Empty!!!", Toast.LENGTH_LONG).show()

            }
        })

    }

    private fun setupSearchButton() {
        btn_search.setOnClickListener {
            Toast.makeText(activity, "Hello test!", Toast.LENGTH_LONG).show()
            //listener.onImageSelected(1)
        }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
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