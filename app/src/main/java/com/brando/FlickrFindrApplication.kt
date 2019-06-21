package com.brando


import com.brando.data.di.component.DaggerDataComponent
import com.brando.data.di.component.DataComponent
import com.brando.data.di.component.DataComponentProvider
import com.brando.flickrfindr.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FlickrFindrApplication : DaggerApplication(), DataComponentProvider {

    private lateinit var dataComponent: DataComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .dataComponent(provideDataComponent())
            .build()
    }

    override fun provideDataComponent(): DataComponent {
        if (!this::dataComponent.isInitialized) {
            dataComponent = DaggerDataComponent
                .builder()
                .build()
        }
        return dataComponent
    }


}