package kr.pe.vero.sample.github.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import kr.pe.vero.sample.github.di.DaggerApplicationComponent

/**
 * @author vero
 * @since 2017. 10. 16.
 */
class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().application(this).create(this)

}