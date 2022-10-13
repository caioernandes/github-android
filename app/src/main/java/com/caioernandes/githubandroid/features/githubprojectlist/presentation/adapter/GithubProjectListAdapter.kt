package com.caioernandes.githubandroid.features.githubprojectlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.caioernandes.common.extensions.loadFromUrl
import com.caioernandes.githubandroid.databinding.ItemGithubProjectBinding
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Item

internal class GithubProjectListAdapter :
    RecyclerView.Adapter<GithubProjectListAdapter.GithubProjectViewHolder>() {

    private var items = arrayListOf<Item>()

    fun addItems(items: List<Item>) {
        if (items.isNotEmpty()) {
            val oldSize = this.items.size
            this.items.addAll(items)
            notifyItemRangeInserted(oldSize, items.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubProjectViewHolder {
        val binding =
            ItemGithubProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubProjectViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class GithubProjectViewHolder(
        private val itemBinding: ItemGithubProjectBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Item) = with(itemBinding) {
            projectName.text = item.name
            forksCount.text = item.forksCount
            stargazersCount.text = item.stargazersCount
            with(item.owner) {
                userAvatar.loadFromUrl(url = avatarUrl)
                userName.text = login
            }
        }
    }
}