package kr.pe.vero.sample.github.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.pe.vero.sample.github.activity.MainActivity

/**
 * @author vero
 * @since 2017. 10. 16.
 */
@Module
abstract class ActivityBindingModule {

//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun contributeMainActivity(): MainActivity

}