package com.brando.data.di.component

import com.brando.data.di.FeatureScope
import com.brando.data.di.module.ApiModule
import dagger.Component

@Component(modules = [ApiModule::class])
@FeatureScope
interface DataComponent {

}