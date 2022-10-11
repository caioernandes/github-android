package com.caioernandes.githubandroid.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caioernandes.githubandroid.R
import com.caioernandes.githubandroid.databinding.ActivityGithubProjectListBinding

class GithubProjectListActivity : AppCompatActivity() {

    private val binding: ActivityGithubProjectListBinding by lazy {
        ActivityGithubProjectListBinding.inflate(layoutInflater)
    }

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