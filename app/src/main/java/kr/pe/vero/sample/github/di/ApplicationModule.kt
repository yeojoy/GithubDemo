package kr.pe.vero.sample.github.di

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kr.pe.vero.sample.github.network.GithubService
import kr.pe.vero.sample.github.viewmodel.ViewModelFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author vero
 * @since 2017. 10. 16.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideContext(application: Application): Context = application

    }

}


