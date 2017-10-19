package kr.pe.vero.sample.github.app

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author vero
 * @since 2017. 10. 16.
 */
open class BaseActivity : DaggerAppCompatActivity() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }

    fun disposable(disposable: Disposable): Disposable {
        this.disposable.add(disposable)
        return this.disposable
    }

}