package kr.pe.vero.sample.github.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.pe.vero.sample.github.model.GithubRepo
import kr.pe.vero.sample.github.network.GithubService
import javax.inject.Inject

/**
 * @author vero
 * @since 2017. 10. 18.
 */
class GithubRepoRepository @Inject constructor(private var service: GithubService): Repository<Flowable<LiveData<List<GithubRepo>>>>() {

    override fun get(params: Bundle?): Flowable<LiveData<List<GithubRepo>>> {
        val query = params?.getString(NAME_QUERY) ?: ""
        return service.find(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { response -> MutableLiveData<List<GithubRepo>>()
                        .apply {
                            Log.d(javaClass.simpleName, "size : ${response.items.size}")
                            value = response.items
                        }
                }
    }

    companion object {

        val NAME_QUERY = "query"

    }

}