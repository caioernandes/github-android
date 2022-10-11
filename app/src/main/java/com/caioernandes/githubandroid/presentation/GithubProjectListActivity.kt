package com.caioernandes.githubandroid.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caioernandes.common.extensions.viewBinding
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding

class GithubProjectListActivity : AppCompatActivity(R.layout.activity_github_project_list) {

    private val binding by viewBinding(ActivityGithubProjectListBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()
    }

    private fun setupToolbar() {
        with(binding.toolbar) {
            setSupportActionBar(this)
            title = getString(R.string.title_activity_github_project_list)
        }
    }
}