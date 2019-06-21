package com.brando


import com.brando.data.di.component.DaggerDataComponent
import com.brando.data.di.component.DataComponent
import com.brando.data.di.component.DataComponentProvider
import com.brando.flickrfindr.BuildConfig
import com.brando.flickrfindr.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class FlickrFindrApplication : DaggerApplication(), DataComponentProvider {

    private lateinit var dataComponent: DataComponent
  //  private lateinit var navigationComponent: NavigationComponent

    override fun onCreate() {
        super.onCreate()

        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .dataComponent(provideDataComponent())
           // .navComponent(provideNavigationComponent())
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

   /* override fun provideNavigationComponent(): NavigationComponent {
        if (!this::navigationComponent.isInitialized) {
            navigationComponent = DaggerNavigationComponent
                .builder()
                .build()
        }
        return navigationComponent
    }*/
}