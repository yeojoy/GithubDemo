package kr.pe.vero.sample.github.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kr.pe.vero.sample.github.databinding.ListItemGithubRepoBinding
import kr.pe.vero.sample.github.model.GithubRepo

/**
 * @author vero
 * @since 2017. 10. 19.
 */
class GithubRepoAdapter: RecyclerView.Adapter<GithubRepoAdapter.GithubRepoViewHolder>() {

    var items: List<GithubRepo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
            GithubRepoViewHolder(ListItemGithubRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.binding.textViewName.text = items[position].name
        holder.binding.textViewDescription.text = items[position].description
    }

    override fun getItemCount() = items.size

    class GithubRepoViewHolder(var binding: ListItemGithubRepoBinding): RecyclerView.ViewHolder(binding.root)

}