package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caioernandes.common.extensions.viewBinding
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubProjectListActivity : AppCompatActivity(R.layout.activity_github_project_list) {

    private val binding by viewBinding(ActivityGithubProjectListBinding::inflate)

    private val viewModel: GithubProjectListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()
        observeViewState()
    }

    private fun setupToolbar() {
        with(binding.toolbar) {
            setSupportActionBar(this)
            title = getString(R.string.title_activity_github_project_list)
        }
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

    private fun showLoadingProgress(isLoading: Boolean) = with(binding) {
        //TODO
    }

    private fun showError(message: String) {
        //TODO
    }

    private fun showGithubProjectData(githubProjectData: GithubProjectData) {
        //TODO
    }
}