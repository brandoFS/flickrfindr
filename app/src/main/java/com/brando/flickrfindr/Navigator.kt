package com.brando.flickrfindr

import androidx.navigation.NavController
import com.brando.imageviewer.ImageFragment
import com.brando.imageviewer.ImageNavigation
import com.brando.search.ui.SearchNavigation
import javax.inject.Singleton

@Singleton
class Navigator : SearchNavigation, ImageNavigation {

    private var navController: NavController? = null

    override fun closeImageViewer() {
        navController?.popBackStack()
    }

    override fun openImageViewer(imageId : Long) {
        navController?.navigate(R.id.action_searchFragment_to_imageFragment, ImageFragment.createBundle(imageId))
    }

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }
}