package com.brando.search.di

import com.brando.search.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSearchFragmentInjector(): SearchFragment
}
