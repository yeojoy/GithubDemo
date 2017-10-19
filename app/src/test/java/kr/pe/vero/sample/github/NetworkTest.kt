package kr.pe.vero.sample.github

import kr.pe.vero.sample.github.network.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author vero
 * @since 2017. 10. 17.
 */
class NetworkTest {

    @Throws(Exception::class)
    @Test
    fun networkTest() {
        val service = provideGithubService(provideRetrofit())
        service.find("google architecture").subscribe()
    }


    private fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun provideGithubService(retrofit: Retrofit) = retrofit.create(GithubService::class.java)

}