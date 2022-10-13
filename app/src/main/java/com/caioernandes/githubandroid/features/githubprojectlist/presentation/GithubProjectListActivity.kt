package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.caioernandes.common.extensions.setupNavigationGraph
import com.caioernandes.common.extensions.viewBinding
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding

class GithubProjectListActivity : AppCompatActivity(R.layout.activity_github_project_list) {

    private val binding by viewBinding(ActivityGithubProjectListBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigationGraph(
            navHostFragmentId = binding.navHostFragment.id,
            graphResId = R.navigation.nav_graph
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            popBackStack()
            return true
        }
        return false
    }

    private fun popBackStack() {
        supportFragmentManager.popBackStack()
    }
}