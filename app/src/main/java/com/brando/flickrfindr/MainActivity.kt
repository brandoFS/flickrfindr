package com.brando.flickrfindr

import android.os.Bundle
import androidx.navigation.findNavController
import com.brando.search.SearchFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), SearchFragment.OnImageSelected {

    override fun onImageSelected(id: Int) {
       // (findNavController(R.id.nav_host_fragment))?.navigate(R.id.action_searchFragment_to_imageFragment)
        navigator.openImageViewer()
    }

    @Inject
    lateinit var navigator: Navigator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.nav_host_fragment))
    }

    override fun onPause() {
        super.onPause()
        navigator.unbind()
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()
}
