package com.caioernandes.githubandroid.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import com.caioernandes.githubandroid.R

internal inline fun <reified F : Fragment> launchFragment() {
    val scenario = launchFragmentInContainer<F>(
        initialState = Lifecycle.State.INITIALIZED,
        themeResId = R.style.Theme_GithubAndroid
    )
    scenario.moveToState(Lifecycle.State.RESUMED)
}