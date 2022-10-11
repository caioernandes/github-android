package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.caioernandes.common.extensions.viewBinding
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.presentation.adapter.GithubProjectAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubProjectListActivity : AppCompatActivity(R.layout.activity_github_project_list) {

    private val binding by viewBinding(ActivityGithubProjectListBinding::inflate)

    private val viewModel: GithubProjectListViewModel by viewModel()

    private val adapter: GithubProjectAdapter by lazy { GithubProjectAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupGithubProjectListRecyclerView()
        observeViewState()
    }

    private fun observeViewState() {
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is GithubProjectListViewState.Loading -> {
                    showLoadingProgress(state.isLoading)
                }
                is GithubProjectListViewState.Failure -> {
                    showError(message = state.error)
                }
                is GithubProjectListViewState.Success -> {
                    showGithubProjectData(githubProjectData = state.githubProjectData)
                }
            }
        }
    }

    private fun setupGithubProjectListRecyclerView() {
        binding.githubProjectListRecyclerView.adapter = adapter
    }

    private fun showLoadingProgress(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading
        githubProjectListRecyclerView.isVisible = isLoading.not()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showGithubProjectData(githubProjectData: GithubProjectData) {
        adapter.submitList(githubProjectData.items)
    }
}