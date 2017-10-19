package kr.pe.vero.sample.github.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.os.Bundle
import android.util.Log
import kr.pe.vero.sample.github.data.GithubRepoRepository
import kr.pe.vero.sample.github.model.GithubRepo
import javax.inject.Inject

/**
 * @author vero
 * @since 2017. 10. 16.
 */
class MainViewModel @Inject constructor(context : Application) : AndroidViewModel(context) {

    @Inject
    lateinit var repository: GithubRepoRepository

    val searchField = ObservableField<String>("")
    var items: MutableLiveData<List<GithubRepo>> = MutableLiveData()

    fun requestGithubRepo() {
        repository.get(Bundle().apply { putString(GithubRepoRepository.NAME_QUERY, searchField.get()) })
                .subscribe(this::onGithubRepoResponse, this::onGithubRepoError)
    }

    private fun onGithubRepoResponse(items: LiveData<List<GithubRepo>>) {
        Log.d(javaClass.simpleName, "size : ${items.value?.size ?: 0}")
        this.items.value = items.value
    }

    private fun onGithubRepoError(throwable: Throwable) {

    }

}