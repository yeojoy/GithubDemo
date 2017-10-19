package kr.pe.vero.sample.github.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kr.pe.vero.sample.github.app.BaseApplication
import javax.inject.Singleton

/**
 * @author vero
 * @since 2017. 10. 16.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ActivityBindingModule::class,
        NetworkModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<BaseApplication>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

    }

}