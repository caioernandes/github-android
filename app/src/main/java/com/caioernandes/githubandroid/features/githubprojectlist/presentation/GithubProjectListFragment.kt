package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.caioernandes.common.extensions.onLastItemScrollListener
import com.caioernandes.common.extensions.showLongToast
import com.caioernandes.common.extensions.viewBinding
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding
import com.caioernandes.githubandroid.databinding.FragmentGithubProjectListBinding
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.presentation.adapter.GithubProjectListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubProjectListFragment : Fragment(R.layout.fragment_github_project_list) {

    private val binding by viewBinding(FragmentGithubProjectListBinding::inflate)

    private val viewModel: GithubProjectListViewModel by viewModel()

    private val adapter: GithubProjectListAdapter by lazy { GithubProjectListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGithubProjectListRecyclerView()
        observeViewState()
        onGetGithubProjectList()
    }

    private fun onGetGithubProjectList() {
        viewModel.onGetGithubProjectList()
    }

    private fun observeViewState() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is GithubProjectListViewState.Loading -> {
                    showLoadingProgress(isLoading = state.isLoading)
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

    private fun setupGithubProjectListRecyclerView() = with(binding) {
        githubProjectListRecyclerView.adapter = adapter
        githubProjectListRecyclerView.onLastItemScrollListener { viewModel.onGetGithubProjectList() }
    }

    private fun showLoadingProgress(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading
        githubProjectListRecyclerView.isVisible = isLoading.not()
    }

    private fun showError(message: String) {
        showLongToast(text = message)
    }

    private fun showGithubProjectData(githubProjectData: GithubProjectData) {
        adapter.addItems(githubProjectData.items)
    }
}