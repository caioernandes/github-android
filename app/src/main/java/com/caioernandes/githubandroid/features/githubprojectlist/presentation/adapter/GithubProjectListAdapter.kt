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
    ListAdapter<Item, GithubProjectListAdapter.GithubProjectViewHolder>(Companion) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubProjectViewHolder {
        val binding =
            ItemGithubProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubProjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

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

    private companion object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}