package kr.pe.vero.sample.github.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author vero
 * @since 2017. 10. 17.
 */
interface GithubService {

    @GET("search/repositories")
    fun find(@Query("q") query: String): Flowable<FindResponse>

}