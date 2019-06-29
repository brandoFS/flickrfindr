package com.brando


import android.app.Activity
import androidx.fragment.app.Fragment
import com.brando.data.di.component.DaggerDataComponent
import com.brando.data.di.component.DataComponent
import com.brando.data.di.component.DataComponentProvider
import com.brando.flickrfindr.BuildConfig
import com.brando.flickrfindr.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class FlickrFindrApplication : DaggerApplication(), DataComponentProvider,HasActivityInjector, HasSupportFragmentInjector {

    private lateinit var dataComponent: DataComponent

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

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

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    /* override fun provideNavigationComponent(): NavigationComponent {
         if (!this::navigationComponent.isInitialized) {
             navigationComponent = DaggerNavigationComponent
                 .builder()
                 .build()
         }
         return navigationComponent
     }*/
}