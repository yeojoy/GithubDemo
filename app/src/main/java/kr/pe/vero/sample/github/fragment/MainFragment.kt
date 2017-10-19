package kr.pe.vero.sample.github.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.pe.vero.sample.github.app.BaseFragment
import kr.pe.vero.sample.github.app.diff.GithubRepoDiffSubscribe
import kr.pe.vero.sample.github.databinding.FragmentMainBinding
import kr.pe.vero.sample.github.view.GithubRepoAdapter
import kr.pe.vero.sample.github.viewmodel.MainViewModel
import kr.pe.vero.sample.github.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * @author vero
 * @since 2017. 10. 16.
 */
class MainFragment @Inject constructor(): BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    private var adapter = GithubRepoAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.recyclerView.adapter = adapter
        binding.buttonSearch.setOnClickListener { if (!TextUtils.isEmpty(viewModel.searchField.get())) viewModel.requestGithubRepo() }

        viewModel.searchField.set("Google Architecture")
        viewModel.items.observe(this, Observer { items ->
            run {
                val oldItems = adapter.items
                Log.d(javaClass.simpleName, "items size : ${items?.size ?: 0}")
                Log.d(javaClass.simpleName, "old items size : ${oldItems.size}, new items size : ${items?.size ?: 0}")
                adapter.items = items?.let { it } ?: arrayListOf()
                Observable.create(GithubRepoDiffSubscribe(oldItems, items))
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result -> result.dispatchUpdatesTo(adapter) })
            }
        })

        return binding.root
    }

}