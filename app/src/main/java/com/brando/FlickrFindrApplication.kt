package com.brando


import com.brando.flickrfindr.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FlickrFindrApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }


}