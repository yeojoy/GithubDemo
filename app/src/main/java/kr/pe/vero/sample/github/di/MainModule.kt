package kr.pe.vero.sample.github.di

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.pe.vero.sample.github.annotation.ViewModelKey
import kr.pe.vero.sample.github.fragment.MainFragment
import kr.pe.vero.sample.github.viewmodel.MainViewModel

/**
 * @author vero
 * @since 2017. 10. 16.
 */
@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}