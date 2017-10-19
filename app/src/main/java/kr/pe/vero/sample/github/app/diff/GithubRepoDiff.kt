package kr.pe.vero.sample.github.app.diff

import android.support.v7.util.DiffUtil
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import kr.pe.vero.sample.github.model.GithubRepo

/**
 * @author vero
 * @since 2017. 10. 19.
 */
class GithubRepoDiffCallback(private var oldList: List<GithubRepo>?, private var newList: List<GithubRepo>?): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList?.size ?: 0

    override fun getNewListSize(): Int = newList?.size ?: 0

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList?.let { it[oldItemPosition] }
        val newItem = newList?.let { it[newItemPosition] }
        return oldItem?.owner == newItem?.owner && oldItem?.name == newItem?.name
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList?.let { it[oldItemPosition] }
        val newItem = newList?.let { it[newItemPosition] }
        return oldItem?.fullName == newItem?.fullName
    }

}

class GithubRepoDiffSubscribe(private var oldList: List<GithubRepo>?, private var newList: List<GithubRepo>?) : ObservableOnSubscribe<DiffUtil.DiffResult> {

    override fun subscribe(e: ObservableEmitter<DiffUtil.DiffResult>) {
        if (e.isDisposed) return
        val result = DiffUtil.calculateDiff(GithubRepoDiffCallback(oldList, newList))
        e.onNext(result)
        e.onComplete()
    }

}